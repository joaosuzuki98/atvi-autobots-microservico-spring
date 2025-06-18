package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.Cliente.ClienteAtualizador;
import com.autobots.automanager.modelo.Cliente.ClienteExcluidor;
import com.autobots.automanager.modelo.Cliente.ClienteSelecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {
	@Autowired
	private ClienteRepositorio repositorio;

	@Autowired
	private ClienteSelecionador selecionador;

	@Autowired
	private ClienteAtualizador atualizador;

	@Autowired
	private ClienteExcluidor excluidor;

	@GetMapping("/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorio.findAll();
		return selecionador.selecionar(clientes, id);
	}

	@GetMapping
	public List<Cliente> obterClientes() {
		List<Cliente> clientes = repositorio.findAll();
		return selecionador.selecionar(clientes);
	}

	@PostMapping
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}

	@PutMapping
	public Cliente atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorio.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizarDados(cliente, atualizacao);
		return repositorio.save(cliente);
	}

	@PutMapping("/multiplos")
	public List<Cliente> atualizarClientes(@RequestBody List<Cliente> c) {
		List<Cliente> alvos = repositorio.findAll();
		atualizador.atualizar(alvos, c);
		return repositorio.saveAll(alvos);
	}

	@DeleteMapping("/{id}")
	public String excluirCliente(@PathVariable Long id) {
		excluidor.excluir(id);
		return "Cliente deletado";
	}

	@DeleteMapping("/multiplos")
	public String excluirClientes(@RequestBody List<Cliente> c) {
		excluidor.excluir(c);
		return "Clientes deletados";
	}
}
