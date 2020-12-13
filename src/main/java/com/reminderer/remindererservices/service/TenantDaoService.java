package com.reminderer.remindererservices.service;

import java.util.List;

public interface TenantDaoService {

	Tenant getTenantById(Long tenantId);

	List<Tenant> getTenantsBulk();
	
}
