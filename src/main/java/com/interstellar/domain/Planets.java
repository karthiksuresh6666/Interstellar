package com.interstellar.domain;

import java.util.List;

public class Planets {

	public List<Planet> planets;

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Planets [planets=");
		builder.append(planets);
		builder.append("]");
		return builder.toString();
	}

}
