package com.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.entity.Fare;
import com.railway.service.FareService;

@RestController
@RequestMapping("/fare")
public class FareController {

	@Autowired
	private FareService fareservice;

	// create new fare
	@PostMapping("/")
	public ResponseEntity<Fare> newFare(@RequestBody Fare fare) {
		Fare fr = this.fareservice.addFare(fare);
		return new ResponseEntity<>(fr, HttpStatus.CREATED);
	}

	// get fare by id
	@GetMapping("/{fare_id}")
	public ResponseEntity<Fare> getById(@PathVariable int fare_id) {
		Fare fr = this.fareservice.getFareById(fare_id);
		return new ResponseEntity<>(fr, HttpStatus.OK);

	}

	// get all fares
	@GetMapping("/")
	public ResponseEntity<List<Fare>> getallfare() {
		List<Fare> list = this.fareservice.getAllFare();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// update fare
	@PutMapping("/{fare_id}")
	public ResponseEntity<Fare> updateFare(@RequestBody Fare fare, @PathVariable int fare_id) {
		Fare fr = this.fareservice.updateFare(fare, fare_id);
		return new ResponseEntity<>(fr, HttpStatus.OK);
	}

}
