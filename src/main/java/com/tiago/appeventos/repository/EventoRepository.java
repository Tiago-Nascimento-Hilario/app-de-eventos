package com.tiago.appeventos.repository;

import org.springframework.data.repository.CrudRepository;

import com.tiago.appeventos.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findByCodigo(Long codigo);
}
