package com.valencia.ejercicio.models.data;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Artista;

public interface IArtista extends CrudRepository<Artista, Integer>{

}
