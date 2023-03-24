package com.railway.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.railway.entity.Trains;

@Component
public interface TrainService {

	List<Trains> getAllTrain();

	Trains getTrainById(int train_id);

	Trains addTrain(Trains trains, int station_id, int time_id);

	Trains updateTrain(int train_id, Trains trains);

}
