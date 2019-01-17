package com.interstellar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Planet {

	@Id
	public String planetNode;

	public String planetName;

	public Planet(String planetNode, String planetName) {
		this.planetNode = planetNode;
		this.planetName = planetName;

	}

	public Planet() {
	}

	public String getPlanetNode() {
		return planetNode;
	}

	public void setPlanetNode(String planetNode) {
		this.planetNode = planetNode;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Planet [planetNode=");
		builder.append(planetNode);
		builder.append(", planetName=");
		builder.append(planetName);
		builder.append("]");
		return builder.toString();
	}

}
