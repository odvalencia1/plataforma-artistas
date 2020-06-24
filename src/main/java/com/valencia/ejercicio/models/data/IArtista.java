package com.valencia.ejercicio.models.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Artista;

public interface IArtista extends CrudRepository<Artista, Integer>{
	@Query("select p from Artista p where p.nombreArtistico> ?1")
    List<Artista> findByNombre(String nombre);
}
