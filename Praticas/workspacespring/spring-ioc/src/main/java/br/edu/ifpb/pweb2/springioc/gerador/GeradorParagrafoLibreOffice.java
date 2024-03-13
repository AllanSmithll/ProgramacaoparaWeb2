package br.edu.ifpb.pweb2.springioc.gerador;

import org.springframework.stereotype.Component;

@Component
public class GeradorParagrafoLibreOffice implements GeradorParagrafoIntf {

    @Override
    public void addParagrafo(String texto) {
        System.out.println("{LibreOffice}" + texto + "/LibreOffice");
    }
    
}
