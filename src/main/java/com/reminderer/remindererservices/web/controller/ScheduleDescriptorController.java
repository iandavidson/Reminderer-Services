package com.reminderer.remindererservices.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminderer.remindererservices.service.schedule.ScheduleDescriptorService;
import com.reminderer.remindererservices.web.dto.schedule.ScheduleDescriptor;
import com.reminderer.remindererservices.web.dto.schedule.ScheduleDescriptorDtoFactory;
import com.reminderer.remindererservices.web.dto.tenant.Tenant;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/schedule-descriptors")
@RestController
@Api(tags = { "Schedule Descriptors" })
public class ScheduleDescriptorController {
	private final ScheduleDescriptorService scheduleDescriptorService;
	private final ScheduleDescriptorDtoFactory scheduleDescriptorDtoFactory;

	public ScheduleDescriptorController(final ScheduleDescriptorService scheduleDescriptorService,
			final ScheduleDescriptorDtoFactory scheduleDescriptorDtoFactory) {
		this.scheduleDescriptorService = scheduleDescriptorService;
		this.scheduleDescriptorDtoFactory = scheduleDescriptorDtoFactory;
	}

	@CrossOrigin(origins = { "*" })
	@GetMapping()
	public ResponseEntity<List<ScheduleDescriptor>> getScheduleDescriptorsBulk(){
		
		List<ScheduleDescriptor> scheduleDescriptors = this.scheduleDescriptorDtoFactory.toScheduleDescriptors(
				this.scheduleDescriptorService.fetchAllScheduleDescriptors());
				//this.scheduleDescriptorService.fetchAllScheduleDescriptors()
		
		return new ResponseEntity<List<ScheduleDescriptor>>(scheduleDescriptors, HttpStatus.OK);
				
	}
	
	@CrossOrigin(origins = { "*" })
	@GetMapping("/{id}")
	public ResponseEntity<ScheduleDescriptor> getScheduleDescriptorById(@PathVariable("id") Long id) {
		log.info("Made it into getScheduleDescriptorById; id: " + id);

		return new ResponseEntity<ScheduleDescriptor>(scheduleDescriptorDtoFactory.to
				HttpStatus.OK);

	}

	// Create

	// find by id

	// delete by id

}
