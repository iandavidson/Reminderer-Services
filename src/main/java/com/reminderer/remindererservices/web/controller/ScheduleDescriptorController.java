package com.reminderer.remindererservices.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminderer.remindererservices.service.schedule.ScheduleDescriptorService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/schedule-descriptor")
@RestController
@Api(tags = { "Schedule Descriptors" })
public class ScheduleDescriptorController {
	private final ScheduleDescriptorService scheduleDescriptorService;
	
	public ScheduleDescriptorController(final ScheduleDescriptorService scheduleDescriptorService) {
		this.scheduleDescriptorService = scheduleDescriptorService;
	}

	
	
	
}
