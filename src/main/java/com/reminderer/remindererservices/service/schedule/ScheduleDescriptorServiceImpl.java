package com.reminderer.remindererservices.service.schedule;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ScheduleDescriptorServiceImpl implements ScheduleDescriptorService {

	private final ScheduleDescriptorDaoService scheduleDescriptorDaoService;

	public ScheduleDescriptorServiceImpl(final ScheduleDescriptorDaoService scheduleDescriptorDaoService) {
		this.scheduleDescriptorDaoService = scheduleDescriptorDaoService;
	}

	@Override
	public Long createScheduleDecriptor(ScheduleDescriptor scheduleDescriptor) {
		return this.scheduleDescriptorDaoService.createScheduleDescriptor(scheduleDescriptor);
	}

	@Override
	public List<ScheduleDescriptor> fetchAllScheduleDescriptors() {
		return this.scheduleDescriptorDaoService.fetchAllScheduleDescriptors();
	}

	@Override
	public ScheduleDescriptor fetchScheduleDescriptorById(Long id) {
		return this.scheduleDescriptorDaoService.fetchScheduleDescriptorById(id);
	}

	@Override
	public Boolean deleteScheduleDescriptor(Long id) {
		return this.scheduleDescriptorDaoService.deleteScheduleDescriptor(id);
	}

}
