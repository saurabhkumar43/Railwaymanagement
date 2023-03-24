package com.railway.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stations")
public class Stations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int station_id;

	@NotEmpty
	@Column(unique = true)
	@Size(min = 2, message = "name must be of minimum 2 characters!!")
	private String station_name;

	@OneToMany
	private List<Trains> trains = new ArrayList<>();
}
