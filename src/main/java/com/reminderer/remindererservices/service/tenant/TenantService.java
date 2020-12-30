package com.reminderer.remindererservices.service.tenant;

import java.util.List;

import com.reminderer.remindererservices.service.util.TenantId;

public interface TenantService {

	Tenant getTenantById(Long tenantId);
	List<Tenant> getTenantsBulk();
	TenantId createTenant(Tenant tenant);
	Boolean deleteTenant(Long tenantId);
}
