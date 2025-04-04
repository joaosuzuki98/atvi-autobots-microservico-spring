package com.autobots.automanager.modelo.Documento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@Component
public class DocumentoExcluidor {

    @Autowired
    private DocumentoRepositorio repositorio;

    public boolean excluir(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public void excluir(List<Documento> documentos) {
        for (Documento documento : documentos) {
            excluir(documento.getId());
        }
    }
}
