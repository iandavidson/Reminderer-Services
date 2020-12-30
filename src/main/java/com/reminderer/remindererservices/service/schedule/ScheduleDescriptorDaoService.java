package com.reminderer.remindererservices.service.schedule;

import java.util.List;

public interface ScheduleDescriptorDaoService {

	List<ScheduleDescriptor> fetchAllScheduleDescriptors();
	Long createScheduleDescriptor(ScheduleDescriptor scheduleDescriptor);
	ScheduleDescriptor fetchScheduleDescriptorById(Long id);
	Boolean deleteScheduleDescriptor(Long id);
	
	//Add soon -> fetchAllScheduleDescriptorsByTenantId(TenantId tenantId)
}
