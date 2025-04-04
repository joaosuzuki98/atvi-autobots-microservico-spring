package com.autobots.automanager.modelo.Documento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Documento;

@Component
public class DocumentoSelecionador {
    public Documento selecionar(List<Documento> documentos, long id) {
        Documento selecionado = null;
        for (Documento documento : documentos) {
            if (documento.getId() == id) {
                selecionado = documento;
            }
        }

        return selecionado;
    }

    public List<Documento> selecionar(List<Documento> documentos) {
        List<Documento> selecionados = new ArrayList<>();
        for (Documento documento : documentos) {
            selecionados.add(documento);
        }

        return selecionados;
    }
}
