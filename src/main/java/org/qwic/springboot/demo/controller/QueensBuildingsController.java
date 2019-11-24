package org.qwic.springboot.demo.controller;

import org.qwic.springboot.demo.bo.QueensBuilding;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Marks class as a controller to define RESTful end points
@RestController
//Tells spring all end points in this class can be sourced at localhost:9000/qwic/demo
@RequestMapping(path="/demo")
public class QueensBuildingsController {
	
	//Specifies HTTP method
	@RequestMapping(path="/buildings", method = RequestMethod.GET)
	public @ResponseBody List<QueensBuilding> buildings(){
		
		QueensBuilding mitchellHall = new QueensBuilding(); 
		mitchellHall.setName("Mitchell Hall");
		mitchellHall.setYear(2019);
		
		List<QueensBuilding> buildings = new ArrayList<>();
		buildings.add(mitchellHall); 
		return buildings;
	}
	
	//Uses PathVarible to handle dynamic changes in URI
	@RequestMapping(path="/building/{name}", method = RequestMethod.GET)
	public String building(@PathVariable String name) {
		
		QueensBuilding mitchellHall = new QueensBuilding(); 
		mitchellHall.setName("Mitchell_Hall");
		mitchellHall.setYear(2019);
		
		if(name.equals(mitchellHall.getName())) {
			return "We are here";
		}
		else {
			return "We are not here";
		}

	}
	

}
