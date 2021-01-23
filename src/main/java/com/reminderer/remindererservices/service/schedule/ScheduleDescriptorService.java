package com.reminderer.remindererservices.service.schedule;

import java.util.List;

public interface ScheduleDescriptorService {
	Long createScheduleDecriptor(ScheduleDescriptor scheduleDescriptor);
	List<ScheduleDescriptor> getAllScheduleDescriptors();
	ScheduleDescriptor getScheduleDescriptorById(Long id);
	Boolean deleteScheduleDescriptor(Long id);
	
}
