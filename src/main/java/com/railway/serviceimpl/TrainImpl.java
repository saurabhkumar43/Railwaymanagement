package com.railway.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entity.Stations;
import com.railway.entity.TimeTable;
import com.railway.entity.Trains;
import com.railway.exception.ResourceNotFoundException;
import com.railway.repository.StationsRepository;
import com.railway.repository.TimeTableRepository;
import com.railway.repository.TrainsRepository;
import com.railway.service.TrainService;

@Service
public class TrainImpl implements TrainService {

	@Autowired
	private TrainsRepository trainsRepository;

	@Autowired
	private StationsRepository stationRepo;

	@Autowired
	private TimeTableRepository timeRepo;

	@Override
	public List<Trains> getAllTrain() {
		List<Trains> list = this.trainsRepository.findAll();
		return list;
	}

	@Override
	public Trains getTrainById(int train_id) {
		Trains train = this.trainsRepository.findById(train_id)
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Train ID", train_id));
		return train;
	}

	@Override
	public Trains addTrain(Trains trains, int station_id, int time_id) {
		Stations station = this.stationRepo.findById(station_id)
				.orElseThrow(() -> new ResourceNotFoundException("station", "station_id", station_id));
		TimeTable time = this.timeRepo.findById(time_id)
				.orElseThrow(() -> new ResourceNotFoundException("Data", "time_id", time_id));
		Trains train = this.trainsRepository.save(trains);
		train.setStation(station);
		train.setTime(time);
		Trains train2 = this.trainsRepository.save(train);
		return train2;
	}

	@Override
	public Trains updateTrain(int train_id, Trains trains) {
		Trains t = this.trainsRepository.findById(train_id)
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Train ID", train_id));
		t.setTrain_number(trains.getTrain_number());
		t.setTrain_name(trains.getTrain_name());
		t.setTrain_type(trains.getTrain_type());
		t.setTrain_status(trains.getTrain_status());
		return this.trainsRepository.save(t);
	}

}
