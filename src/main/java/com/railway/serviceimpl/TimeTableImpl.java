package com.railway.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entity.TimeTable;
import com.railway.exception.ResourceNotFoundException;
import com.railway.repository.TimeTableRepository;
import com.railway.service.TimeTableService;

@Service
public class TimeTableImpl implements TimeTableService {

	@Autowired
	private TimeTableRepository timetablerepository;

	@Override
	public List<TimeTable> getAllTimeTable() {
		List<TimeTable> list = this.timetablerepository.findAll();
		return list;
	}

	@Override
	public TimeTable addTime(TimeTable timetable) {
		return timetablerepository.save(timetable);
	}

	@Override
	public TimeTable getTimeById(int tmtb_id) {
		return timetablerepository.findById(tmtb_id)
				.orElseThrow(() -> new ResourceNotFoundException("Data", "Time Id", tmtb_id));
	}

	@Override
	public TimeTable updateTimeTable(TimeTable timetable, int tmtb_id) {
		TimeTable tt = timetablerepository.findById(tmtb_id)
				.orElseThrow(() -> new ResourceNotFoundException("Data", "Time Id", tmtb_id));
		tt.setDeparture_time(timetable.getDeparture_time());
		tt.setArrival_time(timetable.getArrival_time());
		tt.setRunning_status(timetable.getRunning_status());
		return timetablerepository.save(tt);
	}

}
