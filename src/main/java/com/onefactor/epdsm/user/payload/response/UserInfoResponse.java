package com.onefactor.epdsm.user.payload.response;

import java.util.List;

import lombok.Data;
@Data
public class UserInfoResponse {
	private Integer id;
	private String username;
	private String email;
	private List<String> roles;
	private String token;
	public UserInfoResponse(Integer id, String username, String email, List<String> roles, String token) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.token = token;
	}
	
}
