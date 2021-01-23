package com.reminderer.remindererservices.dao.tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reminderer.remindererservices.service.tenant.TenantDaoService;
import com.reminderer.remindererservices.service.util.TenantId;

@Service
public class TenantDaoServiceImpl implements TenantDaoService {

	private final TenantDaoFactory tenantDaoFactory;
	private final TenantRepository tenantRepository;

	public TenantDaoServiceImpl(final TenantRepository tenantRepository, final TenantDaoFactory tenantDaoFactory) {
		this.tenantRepository = tenantRepository;
		this.tenantDaoFactory = tenantDaoFactory;
		this.initializeTenants();
	}

	protected void initializeTenants() {
//		INSERT INTO tenant (name, report_email_address) VALUES
//		  ('Ian', 'ianmattdavidson@gmail.com'),
//		  ('Tyler', 'awesomeExample@gmail.com'),
//	      ('Brandon','bdonsmash@gmail.com');		  
		List<Tenant> tenants = new ArrayList<>();

		tenants.add(Tenant.builder().id(Long.valueOf(1)).name("Ian").reportEmailAddress("ianmattdavidson@gmail.com")
				.build());

		tenants.add(Tenant.builder().id(Long.valueOf(2)).name("Johnny Boy").reportEmailAddress("johnnyboy@gmail.com")
				.build());
		
		tenants.add(Tenant.builder().id(Long.valueOf(3)).name("Dephlef Shremp").reportEmailAddress("no-reply@google.com")
				.build());
		
		this.tenantRepository.saveAll(tenants);

	}

	@Override
	public com.reminderer.remindererservices.service.tenant.Tenant getTenantById(Long tenantId) {
		if (tenantId == null) {
			throw new IllegalArgumentException("TenantId does not exist.");
		}

		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);

		if (optionalTenant.isEmpty()) {
			return null;
		}

		return tenantDaoFactory.toTenant(optionalTenant.get());
	}

	@Override
	public List<com.reminderer.remindererservices.service.tenant.Tenant> getTenantsBulk() {
		List<Tenant> tenantDaos = tenantRepository.findAll();

		List<com.reminderer.remindererservices.service.tenant.Tenant> tenants = new ArrayList<>();

		tenantDaos.forEach(tenant -> tenants.add(tenantDaoFactory.toTenant(tenant)));

		return tenants;
	}

	@Override
	public TenantId createTenant(com.reminderer.remindererservices.service.tenant.Tenant tenant) {
		Tenant tenantDao = tenantDaoFactory.toTenantDao(tenant);

		tenantRepository.save(tenantDao);

		if (tenantDao.getId() == null) {
			throw new IllegalArgumentException("Tenant successfully persisted, but id value is still null, exiting");
		}

		return tenantDaoFactory.toTenantId(tenantDao.getId());

	}

	@Override
	public Boolean deleteTenant(Long tenantId) {
		// log.debug("Made it into deleteTenant; id: " + tenantId);

		// need to do a better job of determining that the entity was removed.

		if (tenantId == null) {
			// log.info("Id passed into method is null");
			throw new IllegalArgumentException("Id object passed in is null");
		}

		this.tenantRepository.deleteById(tenantId);

		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);

		if (optionalTenant.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
