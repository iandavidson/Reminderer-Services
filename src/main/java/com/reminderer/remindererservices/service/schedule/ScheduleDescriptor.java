package com.reminderer.remindererservices.service.schedule;

import java.time.LocalDateTime;

import com.reminderer.remindererservices.service.util.TenantId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ScheduleDescriptor {
	private Long id;

	private String schedule;

	private String reminder;

	private TenantId tenantId;

	private LocalDateTime creationDate;
}
