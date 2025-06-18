package com.autobots.automanager.modelo.Telefone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@Component
public class TelefoneExcluidor {

    @Autowired
    private TelefoneRepositorio repositorio;

    public boolean excluir(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public void excluir(List<Telefone> telefones) {
        for (Telefone telefone : telefones) {
            excluir(telefone.getId());
        }
    }
}
