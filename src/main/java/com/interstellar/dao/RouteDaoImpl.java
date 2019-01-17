package com.interstellar.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interstellar.domain.PlanetRoute;
import com.interstellar.repositories.RouteRepository;

@Repository
public class RouteDaoImpl implements RouteDao {

	@Autowired
	private RouteRepository routeRepository;

	@Override
	public List<PlanetRoute> retrieveAllRoutes() {
		List<PlanetRoute> routes = new ArrayList<>();
		routeRepository.findAll().forEach(routes::add);
		return routes;
	}

	@Override
	public void saveRoutes(List<PlanetRoute> routeList) {
		routeList.stream().forEach(route -> {
			routeRepository.save(route);
		});
	}

}
