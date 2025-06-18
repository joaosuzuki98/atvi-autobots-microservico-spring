package com.autobots.automanager.controles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.Telefone.TelefoneAtualizador;
import com.autobots.automanager.modelo.Telefone.TelefoneCriador;
import com.autobots.automanager.modelo.Telefone.TelefoneExcluidor;
import com.autobots.automanager.modelo.Telefone.TelefoneSelecionador;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {

    @Autowired
    private TelefoneRepositorio repositorio;

    @Autowired
    private TelefoneSelecionador selecionador;

    @Autowired
    private TelefoneCriador criador;

    @Autowired
    private TelefoneAtualizador atualizador;

    @Autowired
    private TelefoneExcluidor excluidor;

    @GetMapping("/{id}")
    public Telefone obterTelefone(@PathVariable Long id) {
        List<Telefone> telefones = repositorio.findAll();
        return selecionador.selecionar(telefones, id);
    }

    @GetMapping
    public List<Telefone> obterTelefones() {
        List<Telefone> telefones = repositorio.findAll();
        return selecionador.selecionar(telefones);
    }

    @PostMapping
    public Optional<Telefone> criarTelefone(@RequestBody Telefone t) {
        return criador.criar(t.getDdd(), t.getNumero());
    }

    @PutMapping
    public Telefone atualizarTelefone(@RequestBody Telefone t) {
        Telefone alvo = repositorio.getById(t.getId());
        atualizador.atualizar(alvo, t);
        return repositorio.save(alvo);
    }

    @PutMapping("/multiplos")
    public List<Telefone> atualizarTelefones(@RequestBody List<Telefone> t) {
        List<Telefone> alvos = repositorio.findAll();
        atualizador.atualizar(alvos, t);
        return repositorio.saveAll(alvos);
    }

    @DeleteMapping("/{id}")
    public String excluirTelefone(@PathVariable Long id) {
        excluidor.excluir(id);
        return "Telefone deletado";
    }

    @DeleteMapping("/multiplos")
    public String excluirTelefones(@RequestBody List<Telefone> t) {
        excluidor.excluir(t);
        return "Telefones deletados";
    }
}
