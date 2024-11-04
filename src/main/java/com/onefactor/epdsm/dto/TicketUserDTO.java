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
}