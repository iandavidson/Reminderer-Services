package com.reminderer.remindererservices.web.dto.schedule;

import java.time.LocalDateTime;

import com.reminderer.remindererservices.web.dto.util.TenantId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDescriptor {
	private Long id;
	private String schedule;
	private String reminder;
	private LocalDateTime creationDate;
	private TenantId tenantId;
}
