package com.onefactor.epdsm.tickets.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticket_track_id", length = 18, nullable = false, unique = true)
    private String ticketTrackId;

    @Column(name = "cat_id", length = 11, nullable = false, columnDefinition = "char(11) default '0'")
    private String catId;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "ticket_body", columnDefinition = "text", nullable = false)
    private String ticketBody;

    @Column(name = "ticket_user", length = 10, nullable = false, columnDefinition = "char(10) default '0'")
    private String ticketUser;

    @Column(name = "opened_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp openedTime;

    @Column(name = "re_open_time")
    private Timestamp reOpenTime;

    @Column(name = "re_open_by", length = 10, nullable = false)
    private String reOpenBy;

    @Column(name = "re_open_by_type", length = 1, nullable = false, columnDefinition = "char(1) default ''")
    private String reOpenByType;

    @Column(name = "user_type", length = 1, nullable = false, columnDefinition = "char(1) default 'U'")
    private String userType;

    @Column(name = "status", length = 1, nullable = false, columnDefinition = "char(1) default 'N'")
    private String status;

    @Column(name = "assigned_on", length = 2)
    private String assignedOn;

    @Column(name = "assigned_date")
    private Timestamp assignedDate;

    @Column(name = "last_replied_by", length = 10, nullable = false)
    private String lastRepliedBy;

    @Column(name = "last_replied_by_type", length = 1, nullable = false)
    private String lastRepliedByType;

    @Column(name = "last_reply_time")
    private Timestamp lastReplyTime;

    @Column(name = "ticket_rating", precision = 1, scale = 0, nullable = false, columnDefinition = "decimal(1,0) unsigned default '0'")
    private BigDecimal ticketRating;

    @Column(name = "priroty", length = 1, nullable = false, columnDefinition = "char(1) default 'L'")
    private String priority;

    @Column(name = "is_public", length = 1, nullable = false, columnDefinition = "char(1) default 'N'")
    private String isPublic;

    @Column(name = "is_open_using_email", length = 1, nullable = false, columnDefinition = "char(1) default 'N'")
    private String isOpenUsingEmail;

    @Column(name = "is_paid_ticket", length = 1, nullable = false, columnDefinition = "char(1) default 'N'")
    private String isPaidTicket;

    @Column(name = "reply_counter", nullable = false, columnDefinition = "int unsigned default '0'")
    private Integer replyCounter;

    @Column(name = "is_user_seen_last_reply", length = 1, nullable = false, columnDefinition = "char(1) default 'N'")
    private String isUserSeenLastReply;
    
}