package com.interstellar.buisness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interstellar.domain.Planet;
import com.interstellar.domain.PlanetGraph;
import com.interstellar.domain.Route;

public class DijkstraAlgorithm {

	private final List<Planet> nodes;
	private final List<Route> edges;
	private Set<Planet> settledNodes;
	private Set<Planet> unSettledNodes;
	private Map<Planet, Planet> predecessors;
	private Map<Planet, Double> distance;

	public DijkstraAlgorithm(PlanetGraph graph) {
		this.nodes = new ArrayList<Planet>(graph.getPlanets());
		this.edges = new ArrayList<Route>(graph.getRoutes());
	}

	public void execute(Planet source) {
		settledNodes = new HashSet<Planet>();
		unSettledNodes = new HashSet<Planet>();
		distance = new HashMap<Planet, Double>();
		predecessors = new HashMap<Planet, Planet>();
		distance.put(source, 0d);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Planet node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(Planet node) {
		List<Planet> adjacentNodes = getNeighbors(node);
		for (Planet target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private double getDistance(Planet node, Planet target) {
		for (Route edge : edges) {
			if (edge.getPlanetOrigin().equals(node) && edge.getPlanetDestination().equals(target)) {
				return edge.getDistance();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Planet> getNeighbors(Planet node) {
		List<Planet> neighbors = new ArrayList<Planet>();
		for (Route edge : edges) {
			if (edge.getPlanetOrigin().equals(node) && !isSettled(edge.getPlanetDestination())) {
				neighbors.add(edge.getPlanetDestination());
			}
		}
		return neighbors;
	}

	private Planet getMinimum(Set<Planet> vertexes) {
		Planet minimum = null;
		for (Planet vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Planet vertex) {
		return settledNodes.contains(vertex);
	}

	private double getShortestDistance(Planet destination) {
		Double d = distance.get(destination);
		if (d == null) {
			return Double.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and NULL
	 * if no path exists
	 */
	public LinkedList<Planet> getPath(Planet target) {
		LinkedList<Planet> path = new LinkedList<>();
		Planet step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}
