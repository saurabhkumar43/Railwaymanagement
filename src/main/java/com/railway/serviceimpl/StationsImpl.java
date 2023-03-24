package com.railway.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entity.Stations;
import com.railway.exception.ResourceNotFoundException;
import com.railway.repository.StationsRepository;
import com.railway.service.StationsService;

@Service
public class StationsImpl implements StationsService {

	@Autowired
	private StationsRepository stationsrepository;

	@Override
	public List<Stations> getAllStations() {
		List<Stations> list = this.stationsrepository.findAll();
		return list;
	}

	@Override
	public Stations addStation(Stations stations) {
		return this.stationsrepository.save(stations);
	}

	@Override
	public Stations getStationById(int station_id) {
		Stations station = this.stationsrepository.findById(station_id)
				.orElseThrow(() -> new ResourceNotFoundException("Station", "Station Id", station_id));
		return station;
	}

	@Override
	public Stations updateStations(Stations stations, int station_id) {
		Stations s = this.stationsrepository.findById(station_id)
				.orElseThrow(() -> new ResourceNotFoundException("Station", "Station Id", station_id));
		s.setStation_name(stations.getStation_name());
		Stations station = this.stationsrepository.save(s);
		return station;
	}

}
