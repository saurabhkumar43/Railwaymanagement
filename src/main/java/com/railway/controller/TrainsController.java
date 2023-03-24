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

import com.railway.entity.Trains;
import com.railway.service.TrainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trains")
public class TrainsController {

	@Autowired
	private TrainService trainService;

	// create new train
	@PostMapping("/station/{station_id}/time/{time_id}")
	public ResponseEntity<Trains> newTrain(@Valid @RequestBody Trains trains, @PathVariable int station_id,
			@PathVariable int time_id) {
		Trains tr = this.trainService.addTrain(trains, station_id, time_id);
		return new ResponseEntity<Trains>(tr, HttpStatus.CREATED);
	}

	// get train by id
	@GetMapping("/{train_id}")
	public ResponseEntity<Trains> getTrainById(@PathVariable int train_id) {
		Trains tr = this.trainService.getTrainById(train_id);
		return new ResponseEntity<>(tr, HttpStatus.OK);
	}

	// get all train
	@GetMapping("/")
	public ResponseEntity<List<Trains>> getalltrain() {
		List<Trains> list = this.trainService.getAllTrain();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// update the train
	@PutMapping("/{train_id}")
	public ResponseEntity<Trains> updateTrain(@Valid @PathVariable int train_id, @RequestBody Trains trains) {
		Trains tr = this.trainService.updateTrain(train_id, trains);
		return new ResponseEntity<>(tr, HttpStatus.OK);
	}

}
