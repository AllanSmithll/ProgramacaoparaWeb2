package br.edu.ifpb.pweb2.bitbankay.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.bitbankay.model.Conta;

@Component
public class ContaRepository {
    private Map<Integer, Conta> repositorio = new HashMap<Integer, Conta>();

    public Conta findById(Integer id) {
        return repositorio.get(id);
    }

    public Conta save(Conta conta) {
        Integer id = null;
        id = (conta.getId() == null) ? this.getMaxId() : conta.getId();
        conta.setId(id);
        repositorio.put(id, conta);
        return conta;
    }

    public List<Conta> findAll() {
        List<Conta> contas = repositorio.values().stream().collect(Collectors.toList());
        return contas;
    }

    public Integer getMaxId() {
        List<Conta> contas = findAll();
        if (contas == null || contas.isEmpty())
            return 1;
        Conta contaMaxId = contas
                .stream()
                .max(Comparator.comparing(Conta::getId))
                .orElseThrow(NoSuchElementException::new);
        return contaMaxId.getId() == null ? 1 : contaMaxId.getId() + 1;
    }
}