package com.interstellar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interstellar.dao.PlanetDao;
import com.interstellar.dao.RouteDao;
import com.interstellar.domain.Planet;
import com.interstellar.domain.PlanetRoute;
import com.interstellar.domain.Planets;
import com.interstellar.domain.Routes;

@Service
public class PlanetService {

	@Autowired
	PlanetDao PlanetDao;
	
	@Autowired
	RouteDao routeDao;

	public Planets retrieveAllPlanets() {
		Planets planets = new Planets();
		List<Planet> planetList = PlanetDao.retrieveAllPlanets();
		planets.setPlanets(planetList);
		return planets;
	}

	public Routes retrieveAllRoutes() {
		Routes routes = new Routes();
		List<PlanetRoute> routeList = routeDao.retrieveAllRoutes();
		routes.setRoutes(routeList);
		return routes;
	}

}
