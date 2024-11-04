package com.onefactor.epdsm.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefactor.epdsm.tickets.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
