package com.vdit.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="account")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Auditable {

	private String userName;
	private String password;
	
	@ManyToMany
	private List<Role> list=new ArrayList<>();
}
