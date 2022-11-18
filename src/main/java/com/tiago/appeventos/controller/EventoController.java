package com.tiago.appeventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiago.appeventos.model.Evento;
import com.tiago.appeventos.repository.EventoRepository;

@Controller
public class EventoController {
    
    @Autowired
    private EventoRepository eventorepository;

    @RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
    public String formulario(){
        return "evento/formularioEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
    public String formulario(Evento evento){
        
        eventorepository.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = eventorepository.findAll();
        mv.addObject("eventos", eventos); 
        return mv;
    }
    @RequestMapping("/{codigo}")
    public ModelAndView detalhesDoEvento(@PathVariable("codigo") long codigo){
        Evento evento = eventorepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesDoEvento");
        mv.addObject("evento", evento);
        return mv;
    }
}
