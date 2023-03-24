package com.railway.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time_table")
public class TimeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tmtb_id;

	@NotNull
	private String departure_time;

	@NotNull
	private String arrival_time;

	@NotNull
	@Size(min = 2, message = "running status must be of minimum 2 characters!!")
	private String running_status;

	@OneToMany
	private List<Trains> trains = new ArrayList<>();
}
