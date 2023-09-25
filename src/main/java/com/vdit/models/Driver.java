package com.vdit.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "driver")
@Data
public class Driver extends Auditable {

	private String name;
	
	private Account user;
	
	private Gender gender;
	
	@OneToOne(mappedBy = "driver")
	private Car car;
	
	private String lecenceDetails;
	
	@Temporal(value = TemporalType.DATE)
	private Date dob;
	
	@Enumerated(value = EnumType.STRING)
	private DriverApprovalStatus  approval;

	@OneToMany(mappedBy = "driver")
	private List<Booking> bookings;
	
	private boolean isAvailable;
	
	@OneToOne
	private ExactLocation home;
	
	@OneToOne
	private ExactLocation lastKnownLocation;
}
