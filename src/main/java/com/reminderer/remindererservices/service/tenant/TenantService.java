package com.reminderer.remindererservices.service.tenant;

import java.util.List;

public interface TenantService {

	Tenant getTenantById(Long tenantId);
	List<Tenant> getTenantsBulk();
}
