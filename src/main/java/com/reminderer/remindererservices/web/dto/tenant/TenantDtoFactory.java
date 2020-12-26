package com.reminderer.remindererservices.web.dto.tenant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TenantDtoFactory {

	public Tenant toTenantDto(com.reminderer.remindererservices.service.tenant.Tenant tenant) {
		return Tenant.builder().id(tenant.getId()).name(tenant.getName())
				.reportEmailAddress(tenant.getReportEmailAddress()).build();
	}
	
	public List<Tenant> toTenantDtos(List<com.reminderer.remindererservices.service.tenant.Tenant> tenants){
		List<Tenant> tenantDtos = new ArrayList<>();
		
		tenants.forEach(tenant ->  tenantDtos.add(toTenantDto(tenant)));
		
		return tenantDtos;
	}
}
