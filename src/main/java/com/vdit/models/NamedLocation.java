package com.vdit.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="namedlocation")
public class NamedLocation extends Auditable{

	@OneToOne
	private ExactLocation exactLocation;
	private String name;
	private String zipCode;
	private String city;
	private String country;
	private String state;
}
