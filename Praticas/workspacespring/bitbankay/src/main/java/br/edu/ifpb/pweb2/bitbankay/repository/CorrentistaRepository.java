package br.edu.ifpb.pweb2.bitbankay.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.bitbankay.model.Correntista;

@Component
public class CorrentistaRepository {
    private Map<Integer, Correntista> repositorio = new HashMap<Integer, Correntista>();

    public Correntista findById(Integer id) {
        return repositorio.get(id);
    }

    public Correntista save(Correntista correntista) {
        Integer id = null;
        id = (correntista.getId() == null) ? this.getMaxId() : correntista.getId();
        correntista.setId(id);
        repositorio.put(id, correntista);
        return correntista;
    }

    public List<Correntista> findAll() {
        List<Correntista> correntistas = repositorio.values().stream().collect(Collectors.toList());
        return correntistas;
    }

    public Integer getMaxId() {
        List<Correntista> contas = findAll();
        if (contas == null || contas.isEmpty())
            return 1;
        Correntista contaMaxId = contas
                .stream()
                .max(Comparator.comparing(Correntista::getId))
                .orElseThrow(NoSuchElementException::new);
        return contaMaxId.getId() == null ? 1 : contaMaxId.getId() + 1;
    }

}