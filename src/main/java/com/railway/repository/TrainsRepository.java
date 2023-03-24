package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Trains;

public interface TrainsRepository extends JpaRepository<Trains, Integer> {

}
