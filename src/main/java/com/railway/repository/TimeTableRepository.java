package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {

}
