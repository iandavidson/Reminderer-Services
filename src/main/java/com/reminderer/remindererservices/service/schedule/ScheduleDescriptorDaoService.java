package com.reminderer.remindererservices.service.schedule;

import java.util.List;

public interface ScheduleDescriptorDaoService {

	List<ScheduleDescriptor> getAllScheduleDescriptors();
	Long createScheduleDescriptor(ScheduleDescriptor scheduleDescriptor);
	ScheduleDescriptor getScheduleDescriptorById(Long id);
	Boolean deleteScheduleDescriptor(Long id);
	
	//Add soon -> fetchAllScheduleDescriptorsByTenantId(TenantId tenantId)
}
