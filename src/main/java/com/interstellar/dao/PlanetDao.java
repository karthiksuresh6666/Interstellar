package com.interstellar.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interstellar.domain.Planet;

@Service
public interface PlanetDao {

	void savePlanets(List<Planet> planetList);

	Planet getById(String id);

	List<Planet> retrieveAllPlanets();

}
