package com.interstellar.buisness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.interstellar.dao.PlanetDao;
import com.interstellar.dao.RouteDao;
import com.interstellar.domain.Planet;
import com.interstellar.domain.PlanetRoute;

@Component
public class Importer {

	@Autowired
	PlanetDao planetDao;
	
	@Autowired
	RouteDao routeDao;

	Map<String, Planet> planetMap;

	public void importAndPersist() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create((ResourceUtils.getFile("classpath:Interstellar.xlsx")));
		List<Planet> planetList = extractSheetOne(workbook);
		List<PlanetRoute> routeList = extractSheetTwo(workbook);
		saveToDatabase(planetList, routeList);
	}

	private void saveToDatabase(List<Planet> planetList, List<PlanetRoute> routeList) {
		planetDao.savePlanets(planetList);
		routeDao.saveRoutes(routeList);
	}

	private List<Planet> extractSheetOne(Workbook workbook) {
		Sheet sheet = workbook.getSheetAt(0);
		planetMap = new HashMap<>();
		List<Planet> planetList = new ArrayList<>();
		sheet.forEach(row -> {
			if (!(row.getRowNum() == 0)) {
				Planet planet = new Planet();
				row.forEach(cell -> {
					switch (cell.getColumnIndex()) {
					case 0:
						planet.setPlanetNode(cell.getRichStringCellValue().getString());
						break;
					case 1:
						planet.setPlanetName(cell.getRichStringCellValue().getString());
						break;
					default:
						System.out.print("");
					}
					planetMap.put(planet.getPlanetNode(), planet);
				});
				planetList.add(planet);
			}
		});
		return planetList;
	}

	private List<PlanetRoute> extractSheetTwo(Workbook workbook) {
		Sheet sheet = workbook.getSheetAt(1);
		List<PlanetRoute> routeList = new ArrayList<>();
		sheet.forEach(row -> {
			if (!(row.getRowNum() == 0)) {
				PlanetRoute route = new PlanetRoute();
				row.forEach(cell -> {
					switch (cell.getColumnIndex()) {
					case 0:
						route.setRouteId((int) cell.getNumericCellValue());
						break;
					case 1:
						route.setPlanetOrigin(cell.getRichStringCellValue().getString());
						break;
					case 2:
						route.setPlanetDestination(cell.getRichStringCellValue().getString());
						break;
					case 3:
						route.setDistance((int) cell.getNumericCellValue());
						break;
					default:
						System.out.print("");
					}
				});
				routeList.add(route);
			}
		});
		return routeList;
	}

}
