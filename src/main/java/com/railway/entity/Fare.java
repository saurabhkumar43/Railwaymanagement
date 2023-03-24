package com.railway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Fare")
public class Fare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fare_id;

	@NotNull
	private String fare_type;

	@NotNull
	@Min(value = 20, message = "must be greater than or equals to 20")
	private int fare_price;

}
