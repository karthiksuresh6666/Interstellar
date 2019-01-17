package com.interstellar.controller;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interstellar.buisness.Importer;

@RestController
@RequestMapping(value = "/data")
public class ImportExcel {

	@Autowired
	Importer importer;

	@RequestMapping(value = "/import", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public @ResponseBody final ResponseEntity<String> importData() {
		try {
			importer.importAndPersist();
		} catch (EncryptedDocumentException e) {
			return new ResponseEntity<>("", HttpStatus.NOT_IMPLEMENTED);
		} catch (InvalidFormatException e) {
			return new ResponseEntity<>("", HttpStatus.NOT_IMPLEMENTED);
		} catch (IOException e) {
			return new ResponseEntity<>("", HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	

}
