package com.railway.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.railway.entity.Stations;

@Component
public interface StationsService {

	List<Stations> getAllStations();

	Stations addStation(Stations stations);

	Stations getStationById(int station_id);

	Stations updateStations(Stations stations, int station_id);

}
