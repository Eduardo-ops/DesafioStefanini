package com.stefanini.hackathon.controller;

import com.stefanini.hackathon.dto.DisciplinaDTO;
import com.stefanini.hackathon.exception.CursoNotFoundException;
import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.mapper.DisciplinaDTOService;
import com.stefanini.hackathon.model.Disciplina;
import com.stefanini.hackathon.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final DisciplinaDTOService disciplinaDTOService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService, DisciplinaDTOService disciplinaDTOService) {
        this.disciplinaService = disciplinaService;
        this.disciplinaDTOService = disciplinaDTOService;
    }

    @Autowired


    @RequestMapping(path = "/disciplina")
    public ModelAndView loadHtml() {

        ModelAndView mv = new ModelAndView("disciplina");
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        mv.addObject("disciplinaDTO", disciplinaDTO);

        return mv;
    }

    @PostMapping(value = "/disciplina")
    public String saveDisciplina(DisciplinaDTO disciplina) throws TurmaNotFoundException, CursoNotFoundException {

        Disciplina newDisciplina = disciplinaDTOService.mapDisciplina(disciplina);

        disciplinaService.save(newDisciplina);

        return "redirect:/disciplina";
    }

}
