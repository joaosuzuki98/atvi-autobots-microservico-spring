package com.autobots.automanager.modelo.Documento;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.StringVerificadorNulo;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentoCriador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    @Autowired
    private DocumentoRepositorio repositorio;

    public Optional<Documento> criar(String tipo, String numero) {
        if (!verificador.verificar(tipo) || !verificador.verificar(numero)) {
            Documento novoDocumento = new Documento();
            novoDocumento.setTipo(tipo);
            novoDocumento.setNumero(numero);
            repositorio.save(novoDocumento);
            return Optional.of(novoDocumento);
        }

        return Optional.empty();
    }
}
