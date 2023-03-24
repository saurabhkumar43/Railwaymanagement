package com.railway.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.railway.entity.TimeTable;

@Component
public interface TimeTableService {
	
	List<TimeTable> getAllTimeTable();
	TimeTable addTime(TimeTable timetable);
	TimeTable getTimeById(int tmtb_id);
	TimeTable updateTimeTable(TimeTable timetable,int tmtb_id);

}
