package br.edu.ifpb.pweb2.bitbankay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String numero;

    private Date data;

    private Set<Transacao> transacoes = new HashSet<Transacao>();

    private Correntista correntista;

    public BigDecimal getSaldo() {
        BigDecimal total = BigDecimal.ZERO;
        for (Transacao t : this.transacoes) {
            total = total.add(t.getValor());
        }
        return total;
    }
}