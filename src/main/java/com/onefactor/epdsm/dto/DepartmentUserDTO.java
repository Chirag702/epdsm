package com.onefactor.epdsm.dto;

import com.onefactor.epdsm.user.entity.SiteUser;

import lombok.Data;

@Data
public class DepartmentUserDTO {
	
	private SiteUser user;
	
	private String departmentName;
	
	
}
