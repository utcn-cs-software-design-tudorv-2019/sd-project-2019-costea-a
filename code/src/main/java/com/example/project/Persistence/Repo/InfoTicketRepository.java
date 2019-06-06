package com.example.project.Persistence.Repo;

import com.example.project.Persistence.Entity.InfoTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoTicketRepository extends JpaRepository<InfoTicket, Integer> {
}
