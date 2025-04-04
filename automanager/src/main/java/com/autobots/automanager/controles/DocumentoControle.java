package com.autobots.automanager.controles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.Documento.DocumentoAtualizador;
import com.autobots.automanager.modelo.Documento.DocumentoCriador;
import com.autobots.automanager.modelo.Documento.DocumentoExcluidor;
import com.autobots.automanager.modelo.Documento.DocumentoSelecionador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/documento")
public class DocumentoControle {
    @Autowired
    private DocumentoRepositorio repositorio;

    @Autowired
    private DocumentoSelecionador selecionador;

    @Autowired
    private DocumentoCriador criador;

    @Autowired
    private DocumentoAtualizador atualizador;

    @Autowired
    private DocumentoExcluidor excluidor;

    @GetMapping("/{id}")
    public Documento obterDocumento(@PathVariable Long id) {
        List<Documento> documentos = repositorio.findAll();
        return selecionador.selecionar(documentos, id);
    }
    
    @GetMapping
    public List<Documento> obterDocumentos() {
        List<Documento> documentos = repositorio.findAll();
        return selecionador.selecionar(documentos);
    }

    @PostMapping
    public Optional<Documento> criarDocumento(@RequestBody Documento d) {
        return criador.criar(d.getTipo(), d.getNumero());
    }

    @PutMapping()
    public Documento atualizarDocumento(@RequestBody Documento d) {
        Documento alvo = repositorio.getById(d.getId());
        atualizador.atualizar(alvo, d);
        return repositorio.save(alvo);
    }

    @PutMapping("/multiplos")
    public List<Documento> atualizarDocumentos(@RequestBody List<Documento> d) {
        List<Documento> alvos = repositorio.findAll();
        atualizador.atualizar(alvos, d);
        return repositorio.saveAll(alvos);
    }

    @DeleteMapping("/{id}")
    public String excluirDocumento(@PathVariable Long id) {
        excluidor.excluir(id);
        return "Documento deletado";
    }

    @DeleteMapping("/multiplos")
    public String excluirDocumentos(@RequestBody List<Documento> d) {
        excluidor.excluir(d);
        return "Documentos deletados";
    }
}
