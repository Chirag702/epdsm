package com.onefactor.epdsm.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefactor.epdsm.dto.TicketUserDTO;
import com.onefactor.epdsm.tickets.entity.Ticket;
import com.onefactor.epdsm.tickets.repository.TicketRepository;
import com.onefactor.epdsm.tickets.service.TicketService;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

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
        return ticketRepository.save(ticket);
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
