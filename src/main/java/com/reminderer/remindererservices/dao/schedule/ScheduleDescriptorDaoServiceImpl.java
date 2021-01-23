package com.reminderer.remindererservices.dao.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reminderer.remindererservices.dao.tenant.Tenant;
import com.reminderer.remindererservices.dao.tenant.TenantRepository;
import com.reminderer.remindererservices.service.schedule.ScheduleDescriptorDaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduleDescriptorDaoServiceImpl implements ScheduleDescriptorDaoService {

	private final ScheduleDescriptorDaoFactory scheduleDescriptorDaoFactory;
	private final ScheduleDescriptorRepository scheduleDescriptorRepository;
	private final TenantRepository tenantRepository; // need to look up parent record

	public ScheduleDescriptorDaoServiceImpl(final ScheduleDescriptorRepository scheduleDescriptorRepository,
			final ScheduleDescriptorDaoFactory scheduleDescriptorDaoFactory, final TenantRepository tenantRepository) {
		this.scheduleDescriptorRepository = scheduleDescriptorRepository;
		this.scheduleDescriptorDaoFactory = scheduleDescriptorDaoFactory;
		this.tenantRepository = tenantRepository;
		this.initializeScheduleDescriptors();
	}

	protected void initializeScheduleDescriptors() {

		List<ScheduleDescriptor> scheduleDescriptors = new ArrayList<>();
		scheduleDescriptors.add(ScheduleDescriptor.builder().id(Long.valueOf(1)).schedule("0 */3 * * * *")
				.reminder("Wow neato").build());

		scheduleDescriptors.add(ScheduleDescriptor.builder().id(Long.valueOf(2)).schedule("0 1 11 ? * *")
				.reminder("Good job sport!").build());
		
		scheduleDescriptors.add(ScheduleDescriptor.builder().id(Long.valueOf(3)).schedule("'0 1 3 ? * *")
				.reminder("Feed Scappy!").build());
		
		scheduleDescriptors.add(ScheduleDescriptor.builder().id(Long.valueOf(3)).schedule("'0 4 3 ? * *")
				.reminder("Feed Coco!").build());
		
		
		scheduleDescriptorRepository.saveAll(scheduleDescriptors);
		// jam this into the repository on startup b/c I can't get data initialized i na
		// .sql file. :P
//		INSERT INTO schedule_descriptor (schedule, reminder, tenant_id) VALUES
//		  ('0 */3 * * * *', 'Wow neato', 1),
//		  ('0 1 11 ? * *', 'Good job sport!', 2),
//		  ('0 1 3 ? * *', 'Feed Scappy & Coco!', 3);

	}

	@Override
	public List<com.reminderer.remindererservices.service.schedule.ScheduleDescriptor> getAllScheduleDescriptors() {
		log.debug("Made it into fetchAllScheduleDescriptors");
		List<com.reminderer.remindererservices.service.schedule.ScheduleDescriptor> scheduleDescriptors = scheduleDescriptorDaoFactory
				.toScheduleDescriptors(this.scheduleDescriptorRepository.findAll());

		return scheduleDescriptors;
	}

	@Override
	public Long createScheduleDescriptor(
			com.reminderer.remindererservices.service.schedule.ScheduleDescriptor scheduleDescriptor) {
		log.debug("Made it into createScheduleDescriptor; ScheduleDescriptor:" + scheduleDescriptor);
		// assume scheduleDescriptor and id are not null; throwing exception if this is
		// the case here.
		if (scheduleDescriptor == null || scheduleDescriptor.getTenantId() == null) {
			throw new IllegalArgumentException("ScheduleDescriptor obj or member tenantId is null.");
		}

		Optional<Tenant> optionalTenant = this.tenantRepository.findById(scheduleDescriptor.getTenantId().getId());

		if (optionalTenant.isEmpty()) {
			throw new IllegalArgumentException(
					"Tenant with id: " + scheduleDescriptor.getTenantId().getId() + "; not found in db");
		}

		ScheduleDescriptor scheduleDescriptorDao = scheduleDescriptorDaoFactory
				.toScheduleDescriptorDao(scheduleDescriptor, optionalTenant.get());

		this.scheduleDescriptorRepository.save(scheduleDescriptorDao);

		return scheduleDescriptorDao.getId();
	}

	@Override
	public com.reminderer.remindererservices.service.schedule.ScheduleDescriptor getScheduleDescriptorById(Long id) {
		log.debug("Made it into fetchScheduleDescriptorById; id: " + id);
		Optional<ScheduleDescriptor> optionalScheduleDescriptorDao = this.scheduleDescriptorRepository.findById(id);

		if (optionalScheduleDescriptorDao.isEmpty()) {
			log.info("fetchScheduleDescriptorById: Could not find ScheduleDescriptor at id: " + id);
			throw new IllegalArgumentException("Could not find ScheduleDescriptor at id:" + id );
		}

		com.reminderer.remindererservices.service.schedule.ScheduleDescriptor scheduleDescriptor = this.scheduleDescriptorDaoFactory
				.toScheduleDescriptor(optionalScheduleDescriptorDao.get());

		return scheduleDescriptor;

	}

	@Override
	public Boolean deleteScheduleDescriptor(Long id) {
		log.debug("Made it into deleteScheduleDescriptor; id: " + id);

		// need to do a better job of determining that the entity was removed.

		if (id == null) {
			log.info("Id passed into method is null");
			throw new IllegalArgumentException("Id object passed in is null");
		}

		this.scheduleDescriptorRepository.deleteById(id);

		return Boolean.TRUE;

	}

}
