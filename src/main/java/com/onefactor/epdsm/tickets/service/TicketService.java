package com.onefactor.epdsm.tickets.service;

import java.util.List;
import java.util.Optional;

import com.onefactor.epdsm.dto.TicketUserDTO;
import com.onefactor.epdsm.tickets.entity.Ticket;

public interface TicketService {

    List<Ticket> getAllTickets();

    TicketUserDTO getTicketById(Integer id);

    Ticket createTicket(Ticket ticket);

    Optional<Ticket> updateTicket(Integer id, Ticket ticket);

    boolean deleteTicket(Integer id);
}
