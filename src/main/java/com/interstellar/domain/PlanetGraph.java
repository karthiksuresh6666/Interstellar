package com.interstellar.domain;

import java.util.List;

public class PlanetGraph {

	private final List<Planet> planets;

	private final List<Route> routes;

	public PlanetGraph(List<Planet> planets, List<Route> routes) {
		this.planets = planets;
		this.routes = routes;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public List<Route> getRoutes() {
		return routes;
	}

}
