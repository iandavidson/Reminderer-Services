package com.reminderer.remindererservices.dao.schedule;

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
	}

	@Override
	public List<com.reminderer.remindererservices.service.schedule.ScheduleDescriptor> fetchAllScheduleDescriptors() {
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
	public com.reminderer.remindererservices.service.schedule.ScheduleDescriptor fetchScheduleDescriptorById(Long id) {
		log.debug("Made it into fetchScheduleDescriptorById; id: " + id);
		Optional<ScheduleDescriptor> optionalScheduleDescriptorDao = this.scheduleDescriptorRepository.findById(id);

		if (optionalScheduleDescriptorDao.isEmpty()) {
			log.info("fetchScheduleDescriptorById: Could not find ScheduleDescriptor at id: " + id);
			return null;
		}

		com.reminderer.remindererservices.service.schedule.ScheduleDescriptor scheduleDescriptor = this.scheduleDescriptorDaoFactory
				.toScheduleDescriptor(optionalScheduleDescriptorDao.get());

		return scheduleDescriptor;
		
	}

	@Override
	public Boolean deleteScheduleDescriptor(Long id) {
		log.debug("Made it into deleteScheduleDescriptor; id: " + id);
		
		//need to do a better job of determining that the entity was removed.
		
		
		if(id == null) {
			log.info("Id passed into method is null");
			throw new IllegalArgumentException("Id object passed in is null");
		}
		
		this.scheduleDescriptorRepository.deleteById(id);

		return Boolean.TRUE;
		
	}

}
