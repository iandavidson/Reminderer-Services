package com.reminderer.remindererservices.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminderer.remindererservices.service.TenantService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/tenants")
@RestController
@Api(tags = { "tenant" })
public class TenantController {
	
	private final TenantService tenantService;
	
	public TenantController(final TenantService tenantService){
		this.tenantService = tenantService;
	}
	
//	@CrossOrigin(origins = { "*" })
//	@PostMapping()
//	public ResponseEntity<Tenant> 
	
	
}
