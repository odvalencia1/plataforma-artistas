package com.valencia.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class MainController {
	@GetMapping(value= {"/","/index.html"})
	public String home(Model model) {
		//el retorno de la vista  que se va a desplegar
		return "index";
	}
	@GetMapping(value="/elements.html")
	public String elemets(Model model) {
		//el retorno de la vista  que se va a desplegar
		return "elements";
	}
}
