package com.vdit.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@Table(name="paymentreciept")
public class PaymentReciept extends Auditable {

	private Double amount;
	
	@ManyToOne
	private PaymnetGateway paymentGateWay;
	
	private String  details;
}
