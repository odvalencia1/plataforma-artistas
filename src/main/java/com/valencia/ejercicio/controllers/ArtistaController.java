package com.valencia.ejercicio.controllers;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.data.IArtista;
import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Genero;
import com.valencia.ejercicio.models.services.IArtistaService;
import com.valencia.ejercicio.models.services.IGeneroService;

@Controller
@RequestMapping(value="/artista")
public class ArtistaController {
	@Autowired
	private IArtistaService srvArtista;
	@Autowired
	private IArtista srvArtista2;
	@Autowired
	private IGeneroService srvGenero;
			
	@GetMapping(value="/create")//https://localhost:8080/Artista/create
	public String create(Model model) {
		Artista artista = new Artista();
		model.addAttribute("title","Registro de nuevo Artista");
		model.addAttribute("artista",artista);model.addAttribute("artista",artista);
		List<Genero> generos = srvGenero.findAll();
		model.addAttribute("generos",generos);
		return "artista/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve (@PathVariable(value="id")Integer id, Model model, RedirectAttributes flash) {
		Artista artista = srvArtista.findById(id);
		if(artista == null) {
			flash.addFlashAttribute("error","El  cliente no existe en la base de datos");
			return "redirect: artista/list";
		}
		else {
		model.addAttribute("artista",artista);
		model.addAttribute("title","Registro de "+" " + artista.getNombreArtistico());
		List<Genero> generos = srvGenero.findAll();
		model.addAttribute("generos",generos);
		return "artista/card";
		}
	}
	@GetMapping(value="/buscar/")
	public String buscar (String nombre, Model model, RedirectAttributes flash) {
		List<Artista> artistas = srvArtista2.findByNombre(nombre);
		model.addAttribute("artistas",artistas);
		model.addAttribute("title","Listado de Artistas");
		return "/";
		}
	@GetMapping(value="/ver/{id}")
	public String ver (@PathVariable(value="id")Integer id, Model model, RedirectAttributes flash) {
		Artista artista = srvArtista.findById(id);
		if(artista == null) {
			flash.addFlashAttribute("error","El  cliente no existe en la base de datos");
			return "redirect: artista/list";
		}
		else {
		model.addAttribute("artista",artista);
		model.addAttribute("title","Registro de "+" " + artista.getNombreArtistico());
		List<Genero> generos = srvGenero.findAll();
		model.addAttribute("generos",generos);
		return "artista/ver";
		}
	}
	
	@GetMapping(value="/update/{id}")
	public String update (@PathVariable(value="id")Integer id, Model model,RedirectAttributes flash) {
		Artista artista = srvArtista.findById(id);
		model.addAttribute("artista",artista);
		model.addAttribute("title","Actalizando el registro de"+" " + artista.getNombreArtistico());
		List<Genero> generos = srvGenero.findAll();
		model.addAttribute("generos",generos);
		return "artista/form";
	}
	
	@GetMapping(value="/evento/{id}")
	public String evento (@PathVariable(value="id")Integer id, Model model,RedirectAttributes flash) {
		Artista artista = srvArtista.findById(id);
		model.addAttribute("artista",artista);
		
		return "artista/form";
	}
	@GetMapping(value="/delete/{id}")
	public String delete (@PathVariable(value="id")Integer id, Model model) {
		srvArtista.delete(id);
		return "redirect:/artista/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Artista> artistas = srvArtista.findAll();
		model.addAttribute("artistas",artistas);
		model.addAttribute("title","Listado de Artistas");
		return "artista/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/Artista/create
	public String save(Artista artista, Model model,  @RequestParam("file") MultipartFile foto) {
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//"+foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				
				artista.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		this.srvArtista.save(artista);
		return "redirect:/artista/list";
	}
}
