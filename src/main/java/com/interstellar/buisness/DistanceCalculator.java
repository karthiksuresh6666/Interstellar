package com.interstellar.buisness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interstellar.dao.PlanetDao;
import com.interstellar.dao.RouteDao;
import com.interstellar.domain.Planet;
import com.interstellar.domain.PlanetGraph;
import com.interstellar.domain.Route;

@Component
public class DistanceCalculator {

	@Autowired
	PlanetDao planetDao;

	@Autowired
	RouteDao routeDao;

	private List<Planet> nodes;

	private List<Route> routes;

	private Map<String, Planet> planetMap;

	public LinkedList<Planet> distanceCalculate(String source, String destination) {
		nodes = setPlanetNodes();
		routes = setRouteNodes(nodes);
		planetMap = new HashMap<>();
		nodes.forEach(node -> {
			planetMap.put(node.getPlanetNode(), node);
		});
		PlanetGraph graph = new PlanetGraph(nodes, routes);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(planetMap.get(source));
		LinkedList<Planet> path = dijkstra.getPath(planetMap.get(destination));
		for (Planet planet : path) {
			System.out.println(planet);
		}
		return path;
	}

	private List<Planet> setPlanetNodes() {
		List<Planet> planetList = new ArrayList<Planet>();
		Planet planet = new Planet("A", "Earth");
		Planet planet1 = new Planet("B", "Moon");
		Planet planet2 = new Planet("C", "Jupiter");
		Planet planet3 = new Planet("D", "Venus");
		Planet planet4 = new Planet("E", "Mars");
		Planet planet5 = new Planet("F", "Saturn");
		Planet planet6 = new Planet("G", "Uranus");
		Planet planet7 = new Planet("H", "Pluto");
		Planet planet8 = new Planet("I", "Neptune");
		Planet planet9 = new Planet("J", "Mercury");
		Planet planet10 = new Planet("K", "Alpha Centauri");
		Planet planet11 = new Planet("L", "Luhman 16");
		Planet planet12 = new Planet("M", "Epsilon Eridani");
		Planet planet13 = new Planet("N", "Groombridge 34");
		Planet planet14 = new Planet("O", "Epsilon Indi");
		Planet planet15 = new Planet("P", "Tau Ceti");
		Planet planet16 = new Planet("Q", "Kapteyn's star");
		Planet planet17 = new Planet("R", "Gliese 687");
		Planet planet18 = new Planet("S", "Gliese 674");
		Planet planet19 = new Planet("T", "Gliese 876#");
		Planet planet20 = new Planet("U", "Gliese 832");
		Planet planet21 = new Planet("V", "Fomalhaut");
		Planet planet22 = new Planet("W", "Virginis");
		Planet planet23 = new Planet("X", "HD 102365");
		Planet planet24 = new Planet("Y", "Gliese 176");
		Planet planet25 = new Planet("Z", "Gliese 436");
		Planet planet26 = new Planet("A'", "Pollux");
		Planet planet27 = new Planet("B'", "Gliese 86");
		Planet planet28 = new Planet("C'", "HIP 57050");
		Planet planet29 = new Planet("D'", "Piscium");
		Planet planet30 = new Planet("E'", "GJ 1214");
		Planet planet31 = new Planet("F'", "Upsilon Andromedae");
		Planet planet32 = new Planet("G'", "Gamma Cephei");
		Planet planet33 = new Planet("H'", "HD 176051");
		Planet planet34 = new Planet("I'", "Gliese 317");
		Planet planet35 = new Planet("J'", "HD 38858");
		Planet planet36 = new Planet("K'", "Ursae Majoris");
		Planet planet37 = new Planet("L'", "X");
		planetList.add(planet);
		planetList.add(planet1);
		planetList.add(planet2);
		planetList.add(planet3);
		planetList.add(planet4);
		planetList.add(planet5);
		planetList.add(planet6);
		planetList.add(planet7);
		planetList.add(planet8);
		planetList.add(planet9);
		planetList.add(planet10);
		planetList.add(planet11);
		planetList.add(planet12);
		planetList.add(planet13);
		planetList.add(planet14);
		planetList.add(planet15);
		planetList.add(planet16);
		planetList.add(planet17);
		planetList.add(planet18);
		planetList.add(planet19);
		planetList.add(planet20);
		planetList.add(planet21);
		planetList.add(planet22);
		planetList.add(planet23);
		planetList.add(planet24);
		planetList.add(planet25);
		planetList.add(planet26);
		planetList.add(planet27);
		planetList.add(planet28);
		planetList.add(planet29);
		planetList.add(planet30);
		planetList.add(planet31);
		planetList.add(planet32);
		planetList.add(planet33);
		planetList.add(planet34);
		planetList.add(planet35);
		planetList.add(planet36);
		planetList.add(planet37);
		return planetList;
	}

	private List<Route> setRouteNodes(List<Planet> planetList) {
		List<Route> routeList = new ArrayList<Route>();
		Route route1 = new Route(1, planetList.get(0), planetList.get(1), 0.44d);
		Route route2 = new Route(2, planetList.get(0), planetList.get(2), 1.89d);
		Route route3 = new Route(3, planetList.get(0), planetList.get(3), 0.10d);
		Route route4 = new Route(4, planetList.get(1), planetList.get(7), 2.44d);
		Route route5 = new Route(5, planetList.get(1), planetList.get(4), 3.45d);
		Route route6 = new Route(6, planetList.get(2), planetList.get(5), 0.49d);
		Route route7 = new Route(7, planetList.get(3), planetList.get(11), 2.34d);
		Route route8 = new Route(8, planetList.get(3), planetList.get(12), 2.61d);
		Route route9 = new Route(9, planetList.get(7), planetList.get(6), 3.71d);
		Route route10 = new Route(10, planetList.get(4), planetList.get(8), 8.090d);
		Route route11 = new Route(11, planetList.get(5), planetList.get(9), 5.460d);
		Route route12 = new Route(12, planetList.get(5), planetList.get(10), 3.670d);
		Route route13 = new Route(13, planetList.get(6), planetList.get(25), 5.250d);
		Route route14 = new Route(14, planetList.get(8), planetList.get(25), 13.97d);
		Route route15 = new Route(15, planetList.get(8), planetList.get(9), 14.78d);
		Route route16 = new Route(16, planetList.get(11), planetList.get(19), 15.23d);
		Route route17 = new Route(17, planetList.get(19), planetList.get(13), 10.43d);
		Route route18 = new Route(18, planetList.get(19), planetList.get(18), 14.22d);
		Route route19 = new Route(19, planetList.get(18), planetList.get(14), 6.02d);
		Route route20 = new Route(20, planetList.get(14), planetList.get(20), 5.26d);
		Route route21 = new Route(21, planetList.get(9), planetList.get(19), 12.34d);
		Route route22 = new Route(22, planetList.get(19), planetList.get(15), 10.10d);
		Route route23 = new Route(23, planetList.get(19), planetList.get(37), 9.95d);
		Route route24 = new Route(24, planetList.get(25), planetList.get(24), 18.91d);
		Route route25 = new Route(25, planetList.get(24), planetList.get(16), 22.04d);
		Route route26 = new Route(26, planetList.get(16), planetList.get(23), 10.51d);
		Route route27 = new Route(27, planetList.get(37), planetList.get(23), 23.61d);
		Route route28 = new Route(28, planetList.get(23), planetList.get(36), 19.94d);
		Route route29 = new Route(29, planetList.get(15), planetList.get(20), 9.31d);
		Route route30 = new Route(30, planetList.get(20), planetList.get(36), 21.23d);
		Route route31 = new Route(31, planetList.get(20), planetList.get(35), 25.96d);
		Route route32 = new Route(32, planetList.get(35), planetList.get(21), 3.16d);
		Route route33 = new Route(33, planetList.get(36), planetList.get(21), 20.42d);
		Route route34 = new Route(34, planetList.get(35), planetList.get(35), 17.10d);
		Route route35 = new Route(35, planetList.get(24), planetList.get(26), 19.52d);
		Route route36 = new Route(36, planetList.get(26), planetList.get(27), 31.56d);
		Route route37 = new Route(37, planetList.get(27), planetList.get(28), 23.13d);
		Route route38 = new Route(38, planetList.get(36), planetList.get(22), 28.89d);
		Route route39 = new Route(39, planetList.get(22), planetList.get(28), 10.64d);
		Route route40 = new Route(40, planetList.get(22), planetList.get(30), 36.19d);
		Route route41 = new Route(41, planetList.get(28), planetList.get(29), 36.48d);
		Route route42 = new Route(42, planetList.get(30), planetList.get(30), 41.26d);
		Route route43 = new Route(43, planetList.get(30), planetList.get(31), 42.07d);
		Route route44 = new Route(44, planetList.get(31), planetList.get(32), 17.63d);
		Route route45 = new Route(45, planetList.get(32), planetList.get(33), 40.48d);
		routeList.add(route1);
		routeList.add(route2);
		routeList.add(route3);
		routeList.add(route4);
		routeList.add(route5);
		routeList.add(route6);
		routeList.add(route7);
		routeList.add(route8);
		routeList.add(route9);
		routeList.add(route10);
		routeList.add(route11);
		routeList.add(route12);
		routeList.add(route13);
		routeList.add(route14);
		routeList.add(route15);
		routeList.add(route16);
		routeList.add(route17);
		routeList.add(route18);
		routeList.add(route19);
		routeList.add(route20);
		routeList.add(route21);
		routeList.add(route22);
		routeList.add(route23);
		routeList.add(route24);
		routeList.add(route25);
		routeList.add(route26);
		routeList.add(route27);
		routeList.add(route28);
		routeList.add(route29);
		routeList.add(route30);
		routeList.add(route31);
		routeList.add(route32);
		routeList.add(route33);
		routeList.add(route34);
		routeList.add(route35);
		routeList.add(route36);
		routeList.add(route37);
		routeList.add(route38);
		routeList.add(route39);
		routeList.add(route40);
		routeList.add(route41);
		routeList.add(route42);
		routeList.add(route43);
		routeList.add(route44);
		routeList.add(route45);
		return routeList;
	}

//	private List<Route> setPlanetRouteNodes(Map<String, Planet> planetMap, List<PlanetRoute> planetRoutes) {
//		List<Route> routeList = new ArrayList<Route>();
//		planetRoutes.forEach(planetRoute -> {
//			Route route1 = new Route(planetRoute.getRouteId(), planetMap.get(planetRoute.getPlanetOrigin()),
//					planetMap.get(planetRoute.getPlanetDestination()), planetRoute.getDistance());
//			routeList.add(route1);
//		});
//		return routeList;
//	}

}
