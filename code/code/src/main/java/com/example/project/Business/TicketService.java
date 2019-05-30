package com.example.project.Business;

import com.example.project.Persistence.Entity.InfoPlay;
import com.example.project.Persistence.Entity.Review;
import com.example.project.Persistence.Entity.Ticket;
import com.example.project.Persistence.Repo.ReviewRepository;
import com.example.project.Persistence.Repo.TicketRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TicketService {
    @Inject
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets()
    {
        return ticketRepository.findAll();
    }

    public Ticket create(Ticket newTicket)
    {
        return ticketRepository.save(newTicket);
    }

}
