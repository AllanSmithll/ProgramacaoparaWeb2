package br.edu.ifpb.pweb2.bitbankay.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Correntista implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private boolean admin;
}