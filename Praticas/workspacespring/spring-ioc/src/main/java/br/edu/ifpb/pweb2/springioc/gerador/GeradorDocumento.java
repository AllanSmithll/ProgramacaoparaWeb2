package br.edu.ifpb.pweb2.springioc.gerador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GeradorDocumento implements GeradorDocumentoIntf {
    @Autowired
    @Qualifier("geradorParagrafoHTML")
    GeradorParagrafoIntf genParagrafo;

    @Override
    public void addTexto(String texto) {
        genParagrafo.addParagrafo(texto);
    }
}
