package com.reminderer.remindererservices.dao.tenant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tenant")
@Builder
@Entity
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String reportEmailAddress;
	private String phoneNumber;
	
	
}
