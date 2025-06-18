package com.autobots.automanager.modelo.Telefone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Telefone;

@Component
public class TelefoneSelecionador {
    public Telefone selecionar(List<Telefone> telefones, long id) {
        Telefone selecionado = null;
        for (Telefone telefone : telefones) {
            if (telefone.getId() == id) {
                selecionado = telefone;
            }
        }

        return selecionado;
    }

    public List<Telefone> selecionar(List<Telefone> telefones) {
        List<Telefone> selecionados = new ArrayList<>();
        for (Telefone telefone : telefones) {
            selecionados.add(telefone);
        }

        return selecionados;
    }
}
