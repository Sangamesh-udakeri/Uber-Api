package com.vdit.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car extends Auditable {

	@ManyToOne
	private Color color;
	
	@OneToOne
	private Driver driver;

	private String modelAndBrand;

	private String plateNumber;
	
	@Enumerated(value = EnumType.STRING)
	private CarType carType;

}
