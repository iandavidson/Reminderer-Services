package com.reminderer.remindererservices.dao.tenant;

import org.springframework.stereotype.Component;

@Component
public class TenantDaoFactory {

	com.reminderer.remindererservices.service.tenant.Tenant toTenant(Tenant tenant) {
		return com.reminderer.remindererservices.service.tenant.Tenant.builder().id(tenant.getId())
				.name(tenant.getName()).reportEmailAddress(tenant.getReportEmailAddress()).build();
	}

	com.reminderer.remindererservices.service.util.TenantId toTenantId(Long id) {
		return com.reminderer.remindererservices.service.util.TenantId.builder().id(id).build();

	}

	Tenant toTenantDao(com.reminderer.remindererservices.service.tenant.Tenant tenantBO) {
		return Tenant.builder().id(tenantBO.getId()).name(tenantBO.getName())
				.reportEmailAddress(tenantBO.getReportEmailAddress()).build();
	}
}
