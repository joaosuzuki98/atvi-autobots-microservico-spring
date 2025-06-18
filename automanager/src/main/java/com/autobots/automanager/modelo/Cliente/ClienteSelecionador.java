package com.autobots.automanager.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;

@Component
public class ClienteSelecionador {
	public Cliente selecionar(List<Cliente> clientes, long id) {
		Cliente selecionado = null;
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				selecionado = cliente;
			}
		}
		return selecionado;
	}

	public List<Cliente> selecionar(List<Cliente> clientes) {
		List<Cliente> selecionados = new ArrayList<>();
		for (Cliente cliente : clientes) {
			selecionados.add(cliente);
		}

		return selecionados;
	}
}