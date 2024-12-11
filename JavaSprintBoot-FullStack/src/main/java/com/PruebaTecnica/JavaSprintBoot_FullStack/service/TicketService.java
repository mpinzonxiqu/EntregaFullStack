package com.PruebaTecnica.JavaSprintBoot_FullStack.service;

import com.PruebaTecnica.JavaSprintBoot_FullStack.model.Ticket;
import com.PruebaTecnica.JavaSprintBoot_FullStack.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket crearTicket(Ticket ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setFechaActualizacion(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public Ticket actualizarTicket(Ticket ticket) {
        ticket.setFechaActualizacion(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public void eliminarTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public Page<Ticket> obtenerTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    public Optional<Ticket> obtenerTicketPorId(Long id) {
        return ticketRepository.findById(id);
    }
}
