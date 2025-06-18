package com.autobots.automanager.modelo.Telefone;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.StringVerificadorNulo;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelefoneCriador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    @Autowired
    private TelefoneRepositorio repositorio;

    public Optional<Telefone> criar(String ddd, String numero) {
        if (!verificador.verificar(ddd) || !verificador.verificar(numero)) {
            Telefone novoTelefone = new Telefone();
            novoTelefone.setDdd(ddd);
            novoTelefone.setNumero(numero);
            repositorio.save(novoTelefone);
            return Optional.of(novoTelefone);
        }

        return Optional.empty();
    }
}
