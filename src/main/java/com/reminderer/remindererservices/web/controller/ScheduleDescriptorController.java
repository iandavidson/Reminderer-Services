package com.reminderer.remindererservices.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminderer.remindererservices.service.schedule.ScheduleDescriptorService;
import com.reminderer.remindererservices.web.dto.schedule.ScheduleDescriptor;
import com.reminderer.remindererservices.web.dto.schedule.ScheduleDescriptorDtoFactory;

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
	public ResponseEntity<List<ScheduleDescriptor>> getScheduleDescriptorsBulk() {

		List<ScheduleDescriptor> scheduleDescriptors = this.scheduleDescriptorDtoFactory
				.toScheduleDescriptors(this.scheduleDescriptorService.getAllScheduleDescriptors());

		return new ResponseEntity<List<ScheduleDescriptor>>(scheduleDescriptors, HttpStatus.OK);

	}

	@CrossOrigin(origins = { "*" })
	@GetMapping("/{id}")
	public ResponseEntity<ScheduleDescriptor> getScheduleDescriptorById(@PathVariable("id") Long id) {
		log.info("Made it into getScheduleDescriptorById; id: " + id);
		ScheduleDescriptor scheduleDescriptor = scheduleDescriptorDtoFactory
				.toScheduleDescriptorDto(this.scheduleDescriptorService.getScheduleDescriptorById(id));

		if (scheduleDescriptor == null) {
			return new ResponseEntity<ScheduleDescriptor>(scheduleDescriptor, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ScheduleDescriptor>(scheduleDescriptor, HttpStatus.OK);

	}

	@CrossOrigin(origins = { "*" })
	@PostMapping()
	public ResponseEntity<String> createScheduleDescriptor(@RequestBody ScheduleDescriptor scheduleDescriptor) {
		log.info("Made it into createScheduleDescriptor");

		Long id = this.scheduleDescriptorService
				.createScheduleDecriptor(this.scheduleDescriptorDtoFactory.toScheduleDescriptor(scheduleDescriptor));

		if (id == null || id == -1) {
			return new ResponseEntity<String>("Failed to persist scheduleDescriptor", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("api/schedule-descriptors/" + id, HttpStatus.CREATED);

	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin(origins = { "*" })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteScheduleDescriptorById(@PathVariable("id") Long id){
		log.info("Made it into deleteScheduleDescriptorById");
		
		Boolean success =  this.scheduleDescriptorService.deleteScheduleDescriptor(id) ;
		
		if(success != null && success) {
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
}
