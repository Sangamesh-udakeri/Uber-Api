package com.vdit.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.TemporalType;
import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(updatable = false)
	private Date createdAtDate;
	@jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(insertable = false)
	private Date updatedAtDate;
	
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof Auditable) {
			
			Auditable auditableObj=(Auditable) obj;
			if(id==null && obj==null ) return true;
			if(id==null || obj==null ) return false;
			
			return id== ((Auditable) obj).id;

		}else {
			return super.equals(obj);
		}
		
	}
	
	public int hashCode() {
		
		return id==null ? 0 :id.hashCode();
	}
}
