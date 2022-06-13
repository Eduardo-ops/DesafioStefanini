package com.stefanini.hackathon.controller;

import com.stefanini.hackathon.dto.TurmaDTO;
import com.stefanini.hackathon.exception.CursoNotFoundException;
import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.mapper.TurmaDTOService;
import com.stefanini.hackathon.model.Turma;
import com.stefanini.hackathon.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaDTOService turmaDTOService;

    @Autowired
    public TurmaController(TurmaService turmaService, TurmaDTOService turmaDTOService) {
        this.turmaService = turmaService;
        this.turmaDTOService = turmaDTOService;
    }

    @Autowired


    @RequestMapping(path = "/turma")
    public ModelAndView loadHtml() {

        ModelAndView mv = new ModelAndView("turma");
        TurmaDTO turmaDTO = new TurmaDTO();

        mv.addObject("turmaDTO", turmaDTO);

        return mv;
    }

    @PostMapping(value = "/turma")
    public String saveTurma(TurmaDTO turma) throws TurmaNotFoundException, CursoNotFoundException {

        Turma newTurma = turmaDTOService.mapTurma(turma);

        turmaService.save(newTurma);

        return "redirect:/turma";
    }

}
