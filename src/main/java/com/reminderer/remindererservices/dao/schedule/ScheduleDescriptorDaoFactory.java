package com.reminderer.remindererservices.dao.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.reminderer.remindererservices.dao.tenant.Tenant;
import com.reminderer.remindererservices.service.util.TenantId;

@Component
public class ScheduleDescriptorDaoFactory {

	public com.reminderer.remindererservices.service.schedule.ScheduleDescriptor toScheduleDescriptor(
			ScheduleDescriptor scheduleDescriptorDao) {
		return com.reminderer.remindererservices.service.schedule.ScheduleDescriptor.builder()
				.creationDate(scheduleDescriptorDao.getCreationDate()).id(scheduleDescriptorDao.getId())
				.tenantId(TenantId.builder().id(scheduleDescriptorDao.getId()).build())
				.schedule(scheduleDescriptorDao.getSchedule())
				.reminder(scheduleDescriptorDao.getReminder()).build();
	}

	public ScheduleDescriptor toScheduleDescriptorDao(
			com.reminderer.remindererservices.service.schedule.ScheduleDescriptor scheduleDescriptor, Tenant tenant) {
		return ScheduleDescriptor.builder().creationDate(scheduleDescriptor.getCreationDate())
				.id(scheduleDescriptor.getId()).tenant(tenant).schedule(scheduleDescriptor.getSchedule()).reminder(scheduleDescriptor.getReminder()).build();

	}

	public List<com.reminderer.remindererservices.service.schedule.ScheduleDescriptor> toScheduleDescriptors(
			List<ScheduleDescriptor> scheduleDescriptorDaos) {
		List<com.reminderer.remindererservices.service.schedule.ScheduleDescriptor> scheduleDescriptors = new ArrayList<>();

		scheduleDescriptorDaos
				.forEach(scheduleDescriptorDao -> scheduleDescriptors.add(toScheduleDescriptor(scheduleDescriptorDao)));
		
		return scheduleDescriptors;
	}

}
