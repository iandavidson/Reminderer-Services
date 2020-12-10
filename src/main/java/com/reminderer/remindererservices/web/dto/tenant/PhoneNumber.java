package com.reminderer.remindererservices.web.dto.tenant;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PhoneNumber {
	private String areaCode;
	private String firstChunk;
	private String secondChunk;
	
	public static PhoneNumber toPhoneNumber(String areaCode, String firstChunk, String secondChunk) {
		if(areaCode == null || firstChunk == null || secondChunk == null) {
			return null;
		}
		
		
		if(areaCode.length() == 4 && areaCode.substring(0, 1) == "1" || areaCode.length() == 3 ) {
			
		}else {
			throw new IllegalArgumentException("Area code is not in 1### or ### form");
		}
		
		// ...  first + second
		
		
		return PhoneNumber.builder().areaCode(areaCode).firstChunk(firstChunk).secondChunk(secondChunk).build();
		
		
		
	}
	
}
