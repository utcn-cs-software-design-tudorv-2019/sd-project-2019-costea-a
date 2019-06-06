package com.example.project.Business;

import com.example.project.Persistence.Entity.InfoTicket;
import com.example.project.Persistence.Repo.InfoTicketRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class InfoTicketService {
    @Inject
    InfoTicketRepository ticketRepository;

    public List<InfoTicket> getAllTickets()
    {
        return ticketRepository.findAll();
    }

    public InfoTicket create(InfoTicket newTicket)
    {
        return ticketRepository.save(newTicket);
    }

}
