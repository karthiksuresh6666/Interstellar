package com.interstellar.domain;

import java.util.List;

public class Routes {

	public List<PlanetRoute> routes;

	public List<PlanetRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<PlanetRoute> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Routes [routes=");
		builder.append(routes);
		builder.append("]");
		return builder.toString();
	}

}
