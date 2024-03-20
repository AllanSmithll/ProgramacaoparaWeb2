package br.edu.ifpb.pweb2.bitbankay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.bitbankay.model.Conta;
import br.edu.ifpb.pweb2.bitbankay.model.Correntista;
import br.edu.ifpb.pweb2.bitbankay.repository.ContaRepository;
import br.edu.ifpb.pweb2.bitbankay.repository.CorrentistaRepository;

@Component
public class ContaService implements Service<Conta, Integer> {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Override
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @Override
    public Conta findById(Integer id) {
        return contaRepository.findById(id);
    }

    @Override
    public Conta save(Conta conta) {
        Correntista correntista = correntistaRepository.findById(conta.getCorrentista().getId());
        conta.setCorrentista(correntista);
        return contaRepository.save(conta);
    }

}
