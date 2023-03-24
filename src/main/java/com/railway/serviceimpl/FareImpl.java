package com.railway.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entity.Fare;
import com.railway.exception.ResourceNotFoundException;
import com.railway.repository.FareRepository;
import com.railway.service.FareService;

@Service
public class FareImpl implements FareService {

	@Autowired
	private FareRepository fareRepository;

	@Override
	public Fare addFare(Fare fare) {
		return fareRepository.save(fare);
	}

	@Override
	public Fare getFareById(int fare_id) {
		Fare fare = this.fareRepository.findById(fare_id)
				.orElseThrow(() -> new ResourceNotFoundException("Fare Details", "Fare Id", fare_id));
		return fare;
	}

	@Override
	public List<Fare> getAllFare() {
		List<Fare> list = fareRepository.findAll();
		return list;
	}

	@Override
	public Fare updateFare(Fare fare, int fare_id) {
		Fare f = this.fareRepository.findById(fare_id)
				.orElseThrow(() -> new ResourceNotFoundException("Fare Details", "Fare Id", fare_id));
		f.setFare_price(fare.getFare_price());
		f.setFare_type(fare.getFare_type());
		Fare fare2 = fareRepository.save(f);
		return fare2;
	}

}
