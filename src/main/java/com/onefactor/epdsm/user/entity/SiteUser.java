package com.onefactor.epdsm.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
@Table(name = "site_user")
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name", length = 100, nullable = false, columnDefinition = "char(100) default ''")
	private String firstName;

	@Column(name = "last_name", length = 100, nullable = false, columnDefinition = "char(100) default ''")
	private String lastName;

	@Column(name = "username", length = 50, nullable = false, columnDefinition = "char(50) default ''")
	private String username;

	@Column(name = "email", length = 100, nullable = false, unique = true, columnDefinition = "char(100) default ''")
	private String email;

	@Column(name = "secondary_email", length = 100, columnDefinition = "char(100) default ''")
	private String secondaryEmail;

	@Column(name = "contact_owner_id", nullable = false)
	private Integer contactOwnerId;

	@Column(name = "contact_owner_name", length = 100, nullable = false)
	private String contactOwnerName;

	@JsonProperty // This annotation will allow password to be included in input
	@JsonIgnore //
	@Column(name = "pass", length = 32, nullable = false)
	private String password;

	@Column(name = "is_verified_email", length = 1, nullable = false, columnDefinition = "char(1) default 'N'")
	private String isVerifiedEmail;

	@Column(name = "gender", length = 6, nullable = false, columnDefinition = "char(6) default ''")
	private String gender;

	@Column(name = "phone", length = 20, nullable = false, columnDefinition = "char(20) default ''")
	private String phone;

	@Column(name = "photo_url", length = 150, nullable = false, columnDefinition = "char(150) default ''")
	private String photoUrl;

	@Column(name = "join_date", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Timestamp joinDate;

	@Column(name = "status", length = 1, nullable = false, columnDefinition = "char(1) default 'A'")
	private String status;

	@Column(name = "user_type", length = 1, nullable = false, columnDefinition = "char(1) default 'U'")
	private String userType;

	@Column(name = "department", columnDefinition = "text", nullable = false)
	private long departmentId;

	@Column(name = "department_name", columnDefinition = "text", nullable = false)
	private String departmentName;

}
