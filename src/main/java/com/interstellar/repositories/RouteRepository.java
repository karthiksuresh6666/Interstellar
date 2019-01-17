package com.interstellar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.interstellar.domain.PlanetRoute;

@Component
public interface RouteRepository extends CrudRepository<PlanetRoute, Long> {
}
