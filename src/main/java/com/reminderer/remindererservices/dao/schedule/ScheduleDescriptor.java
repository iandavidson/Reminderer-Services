package com.reminderer.remindererservices.dao.schedule;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.reminderer.remindererservices.dao.tenant.Tenant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule_descriptor")
@Builder
@Entity
public class ScheduleDescriptor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String schedule;
	private String reminder;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenant_id", referencedColumnName = "id")
	@ToString.Exclude
	private Tenant tenant;

	@CreationTimestamp
	private LocalDateTime creationDate;
}
