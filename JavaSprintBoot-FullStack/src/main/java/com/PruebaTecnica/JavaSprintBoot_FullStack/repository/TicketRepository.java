package com.PruebaTecnica.JavaSprintBoot_FullStack.repository;

import com.PruebaTecnica.JavaSprintBoot_FullStack.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
