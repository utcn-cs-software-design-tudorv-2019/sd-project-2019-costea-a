package com.example.project.Persistence.Repo;

import com.example.project.Persistence.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
