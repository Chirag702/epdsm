package com.onefactor.epdsm.user.payload.request;

import java.sql.Timestamp;
import java.util.Set;

import com.onefactor.epdsm.user.entity.SiteUser;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignupRequest {

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private String secondaryEmail;

	private Integer contactOwnerId;

	private String contactOwnerName;

	private String password;

	private String isVerifiedEmail;

	private String gender;

	private String phone;

	private String photoUrl;

	private Timestamp joinDate;

	private String status;

	private String userType;

	private long departmentId;

	private String departmentName;

	private Set<String> role;

}
