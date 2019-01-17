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

import com.interstellar.domain.Planets;
import com.interstellar.service.PlanetService;

@RestController
@RequestMapping(value = "/planet")
public class PlanetController {

	@Autowired
	PlanetService planetService;

	@RequestMapping(value = "/showall", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public @ResponseBody final ResponseEntity<Planets> retrieveData() {
		Planets planets = null;
		try {
			planets = planetService.retrieveAllPlanets();
		} catch (EncryptedDocumentException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<>(planets, HttpStatus.OK);
	}

}
