package br.edu.ifpb.pweb2.bitbankay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.bitbankay.model.Correntista;
import br.edu.ifpb.pweb2.bitbankay.repository.CorrentistaRepository;

@Component
public class CorrentistaService implements Service<Correntista, Integer> {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Override
    public List<Correntista> findAll() {
        return correntistaRepository.findAll();
    }

    @Override
    public Correntista findById(Integer id) {
        return correntistaRepository.findById(id);
    }

    @Override
    public Correntista save(Correntista c) {
        return correntistaRepository.save(c);
    }

}
