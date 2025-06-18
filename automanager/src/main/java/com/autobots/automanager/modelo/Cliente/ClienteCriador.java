package com.autobots.automanager.modelo.Cliente;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.StringVerificadorNulo;
import com.autobots.automanager.repositorios.ClienteRepositorio;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteCriador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    @Autowired
    private ClienteRepositorio repositorio;

    public Optional<Cliente> criar(String nome, String nomeSocial, Date dataNascimento, Date dataCadastro, List<Documento> documentos, Endereco endereco, List<Telefone> telefones) {
        if (!verificador.verificar(nome) || !verificador.verificar(nomeSocial) || dataNascimento != null || dataCadastro != null || documentos != null || endereco != null || telefones != null) {
            Cliente novoCliente = new Cliente();
            novoCliente.setNome(nome);
            novoCliente.setNomeSocial(nomeSocial);
            novoCliente.setDataNascimento(dataNascimento);
            novoCliente.setDataCadastro(dataCadastro);
            novoCliente.setDocumentos(documentos);
            novoCliente.setEndereco(endereco);
            novoCliente.setTelefones(telefones);
            repositorio.save(novoCliente);
            return Optional.of(novoCliente);
        }

        return Optional.empty();
    }
}
