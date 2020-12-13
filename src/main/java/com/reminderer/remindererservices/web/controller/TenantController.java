package com.reminderer.remindererservices.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminderer.remindererservices.service.TenantService;
import com.reminderer.remindererservices.web.dto.tenant.Tenant;
import com.reminderer.remindererservices.web.dto.tenant.TenantDtoFactory;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/tenants")
@RestController
@Api(tags = { "tenant" })
public class TenantController {

	private final TenantService tenantService;
	private final TenantDtoFactory tenantDtoFactory;

	public TenantController(final TenantService tenantService, final TenantDtoFactory tenantDtoFactory) {
		this.tenantService = tenantService;
		this.tenantDtoFactory = tenantDtoFactory;
	}

//	@CrossOrigin(origins = { "*" })
//	@PostMapping()
//	public ResponseEntity<Tenant> createTenant(Tenant newTenant){
//		
//	}
//	
	@CrossOrigin(origins = { "*" })
	@GetMapping()
	public ResponseEntity<List<Tenant>> getTenantsBulk(){
		log.info("Made it into getTenantsBulk()");
		
		return new ResponseEntity<List<Tenant>>(tenantDtoFactory.toTenantDtos(tenantService.getTenantsBulk()), HttpStatus.OK);
		
	}

	@CrossOrigin(origins = { "*" })
	@GetMapping("/{tenantId}")
	public ResponseEntity<Tenant> getTenantById(@PathVariable("tenantId") Long tenantId) {
		log.info("Made it into getTenantById; id: " + tenantId);
		
		return new ResponseEntity<Tenant>(tenantDtoFactory.toTenantDto(tenantService.getTenantById(tenantId)), HttpStatus.BAD_REQUEST);

	}

}
