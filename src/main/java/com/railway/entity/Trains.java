package com.railway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trains")
public class Trains {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int train_id;

	@NotNull
	@Min(value = 1000)
	@Column(unique = true)
	private int train_number;

	@NotEmpty
	@Column(unique = true)
	@Size(min = 2, message = "name must be of minimum 2 characters!!")
	private String train_name;

	@NotEmpty
	@Size(min = 2, message = "train type must be of minimum 2 characters!!")
	private String train_type;

	@NotEmpty
	@Size(min = 2, message = "train status must be of minimum 2 characters!!")
	private String train_status;

//	@ManyToMany
//	private List<Stations> stations = new ArrayList<>();

	@ManyToOne
	private Stations station;

	@ManyToOne
	private TimeTable time;
}
