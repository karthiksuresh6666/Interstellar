package com.interstellar.domain;

public class Route {

	public int routeId;

	public Planet planetOrigin;

	public Planet planetDestination;

	public double distance;

	public Route(int routeId, Planet planetOrigin, Planet planetDestination, double distance) {
		this.routeId = routeId;
		this.planetOrigin = planetOrigin;
		this.planetDestination = planetDestination;
		this.distance = distance;
	}

	public Route() {
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Planet getPlanetOrigin() {
		return planetOrigin;
	}

	public void setPlanetOrigin(Planet planetOrigin) {
		this.planetOrigin = planetOrigin;
	}

	public Planet getPlanetDestination() {
		return planetDestination;
	}

	public void setPlanetDestination(Planet planetDestination) {
		this.planetDestination = planetDestination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Route [routeId=");
		builder.append(routeId);
		builder.append(", planetOrigin=");
		builder.append(planetOrigin);
		builder.append(", planetDestination=");
		builder.append(planetDestination);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

}
