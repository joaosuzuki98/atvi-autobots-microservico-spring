package com.autobots.automanager.modelo.Endereco;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.StringVerificadorNulo;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoCriador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    @Autowired
    private EnderecoRepositorio repositorio;

    public Optional<Endereco> criar(String estado, String cidade, String bairro, String rua, String numero, String codigoPostal) {
        if (!verificador.verificar(estado) || !verificador.verificar(cidade) || !verificador.verificar(bairro) || !verificador.verificar(rua) || !verificador.verificar(numero) || !verificador.verificar(codigoPostal)) {
            Endereco novoEndereco = new Endereco();
            novoEndereco.setEstado(estado);
            novoEndereco.setCidade(cidade);
            novoEndereco.setBairro(bairro);
            novoEndereco.setRua(rua);
            novoEndereco.setNumero(numero);
            novoEndereco.setCodigoPostal(codigoPostal);
            repositorio.save(novoEndereco);
            return Optional.of(novoEndereco);
        }

        return Optional.empty();
    }
}
