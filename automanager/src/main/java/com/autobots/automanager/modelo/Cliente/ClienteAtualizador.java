package com.autobots.automanager.modelo.Cliente;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.StringVerificadorNulo;
import com.autobots.automanager.modelo.Documento.DocumentoAtualizador;
import com.autobots.automanager.modelo.Endereco.EnderecoAtualizador;
import com.autobots.automanager.modelo.Telefone.TelefoneAtualizador;

@Component
public class ClienteAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	private EnderecoAtualizador enderecoAtualizador = new EnderecoAtualizador();
	private DocumentoAtualizador documentoAtualizador = new DocumentoAtualizador();
	private TelefoneAtualizador telefoneAtualizador = new TelefoneAtualizador();

	public void atualizarDados(Cliente cliente, Cliente atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getNome())) {
				cliente.setNome(atualizacao.getNome());
			}
			if (!verificador.verificar(atualizacao.getNomeSocial())) {
				cliente.setNomeSocial(atualizacao.getNomeSocial());
			}
			if (!(atualizacao.getDataCadastro() == null)) {
				cliente.setDataCadastro(atualizacao.getDataCadastro());
			}
			if (!(atualizacao.getDataNascimento() == null)) {
				cliente.setDataNascimento(atualizacao.getDataNascimento());
			}
		}
	}

	public void atualizar(List<Cliente> clientes, List<Cliente> atualizacoes) {
		for (Cliente atualizacao : atualizacoes) {
			for (Cliente cliente : clientes) {
				if (atualizacao.getId() == cliente.getId()) {
					atualizarDados(cliente, atualizacao);
				}
			}
		}
	}
}
