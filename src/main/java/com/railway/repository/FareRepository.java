package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Fare;

public interface FareRepository extends JpaRepository<Fare, Integer> {

}
