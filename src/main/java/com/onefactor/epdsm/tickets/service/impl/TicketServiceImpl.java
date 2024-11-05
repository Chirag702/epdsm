package com.onefactor.epdsm.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.onefactor.epdsm.dto.TicketUserDTO;
import com.onefactor.epdsm.tickets.common.GenerateTicketId;
import com.onefactor.epdsm.tickets.entity.Ticket;
import com.onefactor.epdsm.tickets.repository.TicketRepository;
import com.onefactor.epdsm.tickets.service.TicketService;

 import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;

	@Autowired
	GenerateTicketId tid;

	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public TicketUserDTO getTicketById(Integer id) {
		return ticketRepository.getTicketById(id);
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
	    // Set the current timestamp for openedTime
	    Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

	    // Initialize a new ticket with default values
	    Ticket newTicket = new Ticket();
	    newTicket.setTicketTrackId(tid.generateCustomString());
	    newTicket.setTicketUser(ticket.getTicketUser() != null ? ticket.getTicketUser() : "2");
	    newTicket.setAssignedOn(ticket.getAssignedOn() != null ? ticket.getAssignedOn() : "");
	    newTicket.setIsOpenUsingEmail(ticket.getIsOpenUsingEmail() != null ? ticket.getIsOpenUsingEmail() : "N");
	    newTicket.setIsPublic(ticket.getIsPublic() != null ? ticket.getIsPublic() : "N");
	    newTicket.setIsPaidTicket(ticket.getIsPaidTicket() != null ? ticket.getIsPaidTicket() : "N");
	    newTicket.setIsUserSeenLastReply(ticket.getIsUserSeenLastReply() != null ? ticket.getIsUserSeenLastReply() : "N");
	    newTicket.setLastRepliedBy(ticket.getLastRepliedBy() != null ? ticket.getLastRepliedBy() : "");
	    newTicket.setLastRepliedByType(ticket.getLastRepliedByType() != null ? ticket.getLastRepliedByType() : "");
	    newTicket.setOpenedTime(ticket.getOpenedTime() != null ? ticket.getOpenedTime() : currentTimestamp);
	    newTicket.setReOpenBy(ticket.getReOpenBy() != null ? ticket.getReOpenBy() : "");
	    newTicket.setReOpenByType(ticket.getReOpenByType() != null ? ticket.getReOpenByType() : "");
	    newTicket.setReplyCounter(ticket.getReplyCounter() != null ? ticket.getReplyCounter() : 0);

	    // Set main fields or defaults
	    newTicket.setCatId(ticket.getCatId() != null ? ticket.getCatId() : "0");
	    newTicket.setTitle(ticket.getTitle() != null ? ticket.getTitle() : "");
	    newTicket.setTicketBody(ticket.getTicketBody() != null ? ticket.getTicketBody() : "");
	    newTicket.setPriority(ticket.getPriority() != null ? ticket.getPriority() : "L");
	    newTicket.setStatus(ticket.getStatus() != null ? ticket.getStatus() : "N");
	    
	    // Set additional fields with defaults
	    newTicket.setUserType(ticket.getUserType() != null ? ticket.getUserType() : "U");
	    newTicket.setAssignedDate(ticket.getAssignedDate() != null ? ticket.getAssignedDate() : null);
	    newTicket.setLastReplyTime(ticket.getLastReplyTime() != null ? ticket.getLastReplyTime() : null);
	    newTicket.setTicketRating(ticket.getTicketRating() != null ? ticket.getTicketRating() : BigDecimal.ZERO);

	    return ticketRepository.save(newTicket);
	}


	@Override
	public Optional<Ticket> updateTicket(Integer id, Ticket ticketDetails) {
		return ticketRepository.findById(id).map(ticket -> {
			ticket.setTicketTrackId(ticketDetails.getTicketTrackId());
			ticket.setCatId(ticketDetails.getCatId());
			ticket.setTitle(ticketDetails.getTitle());
			ticket.setTicketBody(ticketDetails.getTicketBody());
			ticket.setTicketUser(ticketDetails.getTicketUser());
			ticket.setOpenedTime(ticketDetails.getOpenedTime());
			ticket.setReOpenTime(ticketDetails.getReOpenTime());
			ticket.setReOpenBy(ticketDetails.getReOpenBy());
			ticket.setReOpenByType(ticketDetails.getReOpenByType());
			ticket.setUserType(ticketDetails.getUserType());
			ticket.setStatus(ticketDetails.getStatus());
			ticket.setAssignedOn(ticketDetails.getAssignedOn());
			ticket.setAssignedDate(ticketDetails.getAssignedDate());
			ticket.setLastRepliedBy(ticketDetails.getLastRepliedBy());
			ticket.setLastRepliedByType(ticketDetails.getLastRepliedByType());
			ticket.setLastReplyTime(ticketDetails.getLastReplyTime());
			ticket.setTicketRating(ticketDetails.getTicketRating());
			ticket.setPriority(ticketDetails.getPriority());
			ticket.setIsPublic(ticketDetails.getIsPublic());
			ticket.setIsOpenUsingEmail(ticketDetails.getIsOpenUsingEmail());
			ticket.setIsPaidTicket(ticketDetails.getIsPaidTicket());
			ticket.setReplyCounter(ticketDetails.getReplyCounter());
			ticket.setIsUserSeenLastReply(ticketDetails.getIsUserSeenLastReply());
			
			return ticketRepository.save(ticket);
		});
	}

	@Override
	public boolean deleteTicket(Integer id) {
		if (ticketRepository.existsById(id)) {
			ticketRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
