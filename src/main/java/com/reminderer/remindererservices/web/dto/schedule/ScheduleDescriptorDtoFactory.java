package com.reminderer.remindererservices.web.dto.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.reminderer.remindererservices.web.dto.util.TenantId;

@Component
public class ScheduleDescriptorDtoFactory {

	public ScheduleDescriptor toScheduleDescriptorDto(
			com.reminderer.remindererservices.service.schedule.ScheduleDescriptor scheduleDescriptor) {
		return ScheduleDescriptor.builder()
				.creationDate(scheduleDescriptor.getCreationDate())
				.id(scheduleDescriptor.getId())
				.schedule(scheduleDescriptor.getSchedule())
				.tenantId(TenantId.builder().id(scheduleDescriptor.getTenantId().getId()).build())
				.build();
	}

	public com.reminderer.remindererservices.service.schedule.ScheduleDescriptor toScheduleDescriptor(
			ScheduleDescriptor scheduleDescriptor) {
		return com.reminderer.remindererservices.service.schedule.ScheduleDescriptor.builder()
				.creationDate(scheduleDescriptor.getCreationDate())
				.id(scheduleDescriptor.getId())
				.schedule(scheduleDescriptor.getSchedule())
				.tenantId(com.reminderer.remindererservices.service.util.TenantId.builder()
						.id(scheduleDescriptor.getTenantId().getId()).build())
				.build();
	}

	public List<ScheduleDescriptor> toScheduleDescriptors(List<com.reminderer.remindererservices.service.schedule.ScheduleDescriptor> scheduleDescriptorDtos){
		List<ScheduleDescriptor> scheduleDescriptors = new ArrayList<>();
		
		scheduleDescriptorDtos.forEach(scheduleDescriptor -> scheduleDescriptors.add(toScheduleDescriptorDto(scheduleDescriptor)));
		
		return scheduleDescriptors;
	}
	
	

}
