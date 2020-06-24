package com.valencia.ejercicio.models.data;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.TipoEstado;

public interface ITipoEstado  extends CrudRepository<TipoEstado, Integer> {

}
