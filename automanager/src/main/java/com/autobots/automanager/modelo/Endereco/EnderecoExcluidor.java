package com.autobots.automanager.modelo.Endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@Component
public class EnderecoExcluidor {

    @Autowired
    private EnderecoRepositorio repositorio;

    public boolean excluir(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public void excluir(List<Endereco> enderecos) {
        for (Endereco endereco : enderecos) {
            excluir(endereco.getId());
        }
    }
}
