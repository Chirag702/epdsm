package com.onefactor.epdsm.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class TicketUserDTO {

	private Integer ticketId;
	private String ticketTrackId;
	private String title;
	private String ticketBody;
	private String status;
	private String priority;
	private Timestamp openedTime;

	// User fields
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	public TicketUserDTO(Integer ticketId, String ticketTrackId, String title, String ticketBody, String status,
			String priority, Timestamp openedTime, Integer userId, String firstName, String lastName, String email,
			String phone) {
		super();
		this.ticketId = ticketId;
		this.ticketTrackId = ticketTrackId;
		this.title = title;
		this.ticketBody = ticketBody;
		this.status = status;
		this.priority = priority;
		this.openedTime = openedTime;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}


}