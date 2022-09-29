package com.fis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.entity.Tour;
import com.fis.service.Tourservice;

@RestController
public class TourController {
	
	@Autowired
	Tourservice tourservice;
	
	

	@GetMapping("/tourPackage")
	public ResponseEntity<List<Tour>> getAllt()
	{
		return new ResponseEntity<>(tourservice.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/tourPackage/{tourid}")
	public ResponseEntity<Tour> get(@PathVariable("tourid") String tourpackid)
	{
		return new ResponseEntity<>(tourservice.get(tourpackid),HttpStatus.OK);
	}
	
	@PostMapping("/tourPackage")
	public ResponseEntity<Tour> create(@RequestBody Tour tour)
	{
			return new ResponseEntity<>(tourservice.create(tour),HttpStatus.CREATED);
	}
	
	@GetMapping("/tourPackage/{tourid}/cost/{nosdays}")
	public ResponseEntity<Double> getcost(@PathVariable("tourid") String tourpackid,@PathVariable("nosdays") int nosdays)
	{
		return new ResponseEntity<>(tourservice.calculate(tourpackid,nosdays),HttpStatus.OK);
	}
	
	
	
}
