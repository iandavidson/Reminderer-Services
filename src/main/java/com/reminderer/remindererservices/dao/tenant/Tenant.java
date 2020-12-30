package com.reminderer.remindererservices.dao.tenant;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.reminderer.remindererservices.dao.schedule.ScheduleDescriptor;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String reportEmailAddress;

	@OneToMany(mappedBy = "tenant", fetch = FetchType.LAZY)
	private Set<ScheduleDescriptor> scheduleDescriptor;
}
