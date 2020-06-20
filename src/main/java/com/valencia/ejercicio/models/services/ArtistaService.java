package com.valencia.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.data.IArtista;
import com.valencia.ejercicio.models.entities.Artista;



@Service
public class ArtistaService {
	@Autowired//Inyeccion de dependencia
	private IArtista dao;
	
	@Transactional
	public void save(Artista a) {
		dao.save(a);
		
	}

	@Transactional
	public Artista findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Transactional
	public List<Artista> findAll() {
		// TODO Auto-generated method stub
		return (List<Artista> )dao.findAll();
	}
}
