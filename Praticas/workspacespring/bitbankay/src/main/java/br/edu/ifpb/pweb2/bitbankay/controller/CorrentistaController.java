package br.edu.ifpb.pweb2.bitbankay.controller;

import br.edu.ifpb.pweb2.bitbankay.model.Correntista;
import br.edu.ifpb.pweb2.bitbankay.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository correntistaRepository;

    @RequestMapping("/form")
    public String getForm(Correntista correntista, Model model) {
        model.addAttribute("correntista", correntista);
        return "correntistas/form";
    }

    @RequestMapping("/save")
    public String save(Correntista correntista, Model model) {
        correntistaRepository.save(correntista);
        model.addAttribute("correntistas", correntistaRepository.findAll());
        return "correntistas/list";
    }
}
