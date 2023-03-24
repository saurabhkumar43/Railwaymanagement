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

import com.railway.entity.TimeTable;
import com.railway.service.TimeTableService;

@RestController
@RequestMapping("/time")
public class TimeTableController {

	@Autowired
	private TimeTableService timetableservice;

	// post time
	@PostMapping("/")
	public ResponseEntity<TimeTable> addTime(@RequestBody TimeTable timetable) {
		TimeTable time = this.timetableservice.addTime(timetable);
		return new ResponseEntity<TimeTable>(time, HttpStatus.CREATED);
	}

	// get all timings
	@GetMapping("/")
	public ResponseEntity<List<TimeTable>> getAll() {
		List<TimeTable> list = this.timetableservice.getAllTimeTable();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// get time by id
	@GetMapping("/{tmtb_id}")
	public ResponseEntity<TimeTable> getById(@PathVariable int tmtb_id) {
		TimeTable time = this.timetableservice.getTimeById(tmtb_id);
		return new ResponseEntity<>(time, HttpStatus.OK);
	}

	@PutMapping("/{tmtb_id}")
	public ResponseEntity<TimeTable> updateTime(@PathVariable int tmtb_id, @RequestBody TimeTable timetable) {
		TimeTable time = this.timetableservice.updateTimeTable(timetable, tmtb_id);
		return new ResponseEntity<TimeTable>(time, HttpStatus.OK);
	}
}
