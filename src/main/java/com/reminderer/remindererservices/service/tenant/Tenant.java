package com.reminderer.remindererservices.service.tenant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Tenant {
	private Long id;
	private String name;
	private String reportEmailAddress;
}
