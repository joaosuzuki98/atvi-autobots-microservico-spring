package com.autobots.automanager.modelo.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Component
public class ClienteExcluidor {
    @Autowired
    private ClienteRepositorio repositorio;

    public boolean excluir(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public void excluir(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            excluir(cliente.getId());
        }
    }
}
