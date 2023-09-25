package com.vdit.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.hibernate.annotations.TenantId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Temporal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passenger")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends Auditable {

	@OneToOne
	private Account user;

	private String name;
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	@OneToMany(mappedBy = "passenger" )
	private List<Booking> bookings=new ArrayList<>();
	
	@jakarta.persistence.Temporal(value = TemporalType.DATE)
	private Date dob;
	
	private String phoneNumber;
	
	@OneToOne
	private ExactLocation home;
	@OneToOne
	private ExactLocation work;
	@OneToOne
	private ExactLocation lastKnownLocation;
	
	
}
