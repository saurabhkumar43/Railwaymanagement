package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Stations;

public interface StationsRepository extends JpaRepository<Stations, Integer> {

}
