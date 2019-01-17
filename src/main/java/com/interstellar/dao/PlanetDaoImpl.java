package com.interstellar.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interstellar.domain.Planet;
import com.interstellar.repositories.PlanetRepository;

@Repository
public class PlanetDaoImpl implements PlanetDao {

	@Autowired
	private PlanetRepository planetRepository;

	@Override
	public void savePlanets(List<Planet> planetList) {
		planetList.stream().forEach(planet -> {
			planetRepository.save(planet);
		});
	}

	@Override
	public List<Planet> retrieveAllPlanets() {
		List<Planet> planets = new ArrayList<>();
		planetRepository.findAll().forEach(planets::add);
		return planets;
	}

	@Override
	public Planet getById(String id) {
		return planetRepository.findOne(id);
	}

}
