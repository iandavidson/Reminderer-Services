package com.reminderer.remindererservices.service;

import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService {
	
	private final TenantDaoService tenantDaoService;
	
	
	public TenantServiceImpl(final TenantDaoService tenantDaoService) {
		this.tenantDaoService = tenantDaoService;
	}
	
	
}
