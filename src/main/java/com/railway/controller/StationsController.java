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

import com.railway.entity.Stations;
import com.railway.service.StationsService;

@RestController
@RequestMapping("/stations")
public class StationsController {

	@Autowired
	private StationsService stationsService;

	// post stations
	@PostMapping("/")
	public ResponseEntity<Stations> newStation(@RequestBody Stations stations) {
		Stations station = this.stationsService.addStation(stations);
		return new ResponseEntity<>(station, HttpStatus.CREATED);
	}

	// get all stations
	@GetMapping("/")
	public ResponseEntity<List<Stations>> getAll() {
		List<Stations> list = this.stationsService.getAllStations();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// get station by id
	@GetMapping("/{station_id}")
	public ResponseEntity<Stations> getById(@PathVariable int station_id) {
		Stations station = this.stationsService.getStationById(station_id);
		return new ResponseEntity<>(station, HttpStatus.OK);
	}

	// update a station
	@PutMapping("/{station_id}")
	public ResponseEntity<Stations> updateStation(@RequestBody Stations stations, @PathVariable int station_id) {
		Stations station = this.stationsService.updateStations(stations, station_id);
		return new ResponseEntity<>(station, HttpStatus.OK);
	}

}
