package com.reminderer.remindererservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
}
