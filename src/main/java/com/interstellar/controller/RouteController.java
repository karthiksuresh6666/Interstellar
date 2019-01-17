package com.interstellar.controller;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interstellar.domain.Routes;
import com.interstellar.service.PlanetService;

@RestController
@RequestMapping(value = "/route")
public class RouteController {

	@Autowired
	PlanetService planetService;

	@RequestMapping(value = "/showall", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public @ResponseBody final ResponseEntity<Routes> retrieveData() {
		Routes routes = null;
		try {
			routes = planetService.retrieveAllRoutes();
		} catch (EncryptedDocumentException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<>(routes, HttpStatus.OK);
	}

}
