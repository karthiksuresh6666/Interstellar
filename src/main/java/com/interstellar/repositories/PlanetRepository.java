package com.interstellar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.interstellar.domain.Planet;

@Component
public interface PlanetRepository extends CrudRepository<Planet, String> {
}
