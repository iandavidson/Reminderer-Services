package com.reminderer.remindererservices.service;

import java.util.List;

public interface TenantService {

	Tenant getTenantById(Long tenantId);
	List<Tenant> getTenantsBulk();
}
