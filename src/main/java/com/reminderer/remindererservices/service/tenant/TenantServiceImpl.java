package com.reminderer.remindererservices.service.tenant;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reminderer.remindererservices.service.util.TenantId;

@Service
public class TenantServiceImpl implements TenantService {
	
	private final TenantDaoService tenantDaoService;
	
	
	public TenantServiceImpl(final TenantDaoService tenantDaoService) {
		this.tenantDaoService = tenantDaoService;
	}


	@Override
	public Tenant getTenantById(Long tenantId) {
		return tenantDaoService.getTenantById(tenantId);		
	}


	@Override
	public List<Tenant> getTenantsBulk() {
		return tenantDaoService.getTenantsBulk();
	}


	@Override
	public TenantId createTenant(Tenant tenant) {
		return tenantDaoService.createTenant(tenant);
		
	}	
	
	
	
	
}
