package com.interstellar.controller;

import java.util.LinkedList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import com.interstellar.buisness.DistanceCalculator;
import com.interstellar.domain.CalculateForm;
import com.interstellar.domain.Planet;

@Controller
@RequestMapping(value = "/distance")
public class CalculateDistance {

	@Autowired
	DistanceCalculator distanceCalculator;
	
	LinkedList<Planet> minDistance = null;

	@RequestMapping("calculate_distance")
	public String redirToList(Model model) {
		model.addAttribute("calculateForm", new CalculateForm());
		return "interstellar/calculate";
	}

	@RequestMapping(value = "/calculate")
	public String saveOrUpdateProduct(@Valid CalculateForm calculateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "interstellar/calculate";
		}
		minDistance = distanceCalculator.distanceCalculate(calculateForm.getPlanetOrigin(),
				calculateForm.getPlanetDestination());
		return "redirect:distance/show";
	}

	@RequestMapping("distance/show")
	public String showPaths(Model model) {
		model.addAttribute("minDistance", minDistance);
		return "interstellar/list";
	}
}
