package br.edu.ifpb.pweb2.bitbankay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String descricao;

    private BigDecimal valor;

    private Date data;

    private Conta conta;
}
