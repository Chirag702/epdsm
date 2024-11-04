package com.onefactor.epdsm.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onefactor.epdsm.dto.TicketUserDTO;
import com.onefactor.epdsm.tickets.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("SELECT new com.onefactor.epdsm.dto.TicketUserDTO("
			+ "t.id, t.ticketTrackId, t.title, t.ticketBody, t.status, t.priority, t.openedTime, "
			+ "u.id, u.firstName, u.lastName, u.email, u.phone) "
			+ "FROM Ticket t JOIN SiteUser u ON t.ticketUser = u.id " + "WHERE t.id = :ticketId")
	TicketUserDTO getTicketById(@Param("ticketId") long ticketId);
}
