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
	}
	
	@Override
	public  com.reminderer.remindererservices.service.tenant.Tenant getTenantById(Long tenantId) {
		if(tenantId == null) {
			throw new IllegalArgumentException("TenantId does not exist.");
		}
		
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		
		if(optionalTenant.isEmpty()) {
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
		
		if(tenantDao.getId() == null) {
			throw new IllegalArgumentException("Tenant successfully persisted, but id value is still null, exiting");
		}
		
		return tenantDaoFactory.toTenantId(tenantDao.getId());
		
	}

}
