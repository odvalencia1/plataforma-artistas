package com.valencia.ejercicio.models.data;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Integrante;

public interface IIntegrante extends CrudRepository<Integrante, Integer> {

}
