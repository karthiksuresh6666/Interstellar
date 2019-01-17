package com.interstellar.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import com.interstellar.domain.PlanetRoute;

@Service
public interface RouteDao {
	
	void saveRoutes(List<PlanetRoute> planetList);
	
	List<PlanetRoute> retrieveAllRoutes();

}
