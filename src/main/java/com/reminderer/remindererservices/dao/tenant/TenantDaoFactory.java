package com.reminderer.remindererservices.dao.tenant;

import org.springframework.stereotype.Component;

@Component
public class TenantDaoFactory {

	com.reminderer.remindererservices.service.Tenant toTenant(Tenant tenant) {
		return com.reminderer.remindererservices.service.Tenant.builder().id(tenant.getId()).name(tenant.getName())
				.reportEmailAddress(tenant.getReportEmailAddress()).build();
	}
}
