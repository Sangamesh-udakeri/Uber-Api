package com.vdit.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="booking")
public class Booking extends Auditable {

	@ManyToOne
	private Passenger passenger;
	
	@ManyToOne
	private Driver  driver;
	
	@Enumerated(value = EnumType.STRING)
	private BookingStatus bookingStatus;
	
	@Enumerated(value = EnumType.STRING)
	private BookingType bookingType;
	
	@OneToOne
	private Riview  reviewByUser;
	
	@OneToOne
	private Riview  reviewByDriver;
	
	@OneToOne
	private PaymentReciept paymentReciept;
	
	private Long totalDistanceInMeters;
	
	@OneToMany
	private List<ExactLocation>  locations=new ArrayList<>();
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date endTime;
	
	@OneToOne
	private Otp rideStartOtp;
}
