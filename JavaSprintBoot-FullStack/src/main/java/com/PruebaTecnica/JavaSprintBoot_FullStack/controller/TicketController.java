package com.PruebaTecnica.JavaSprintBoot_FullStack.controller;

import com.PruebaTecnica.JavaSprintBoot_FullStack.model.Ticket;
import com.PruebaTecnica.JavaSprintBoot_FullStack.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> crearTicket(@RequestBody Ticket ticket) {
        Ticket nuevoTicket = ticketService.crearTicket(ticket);
        return ResponseEntity.ok(nuevoTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> actualizarTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket ticketActualizado = ticketService.actualizarTicket(ticket);
        return ResponseEntity.ok(ticketActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Ticket>> obtenerTickets(Pageable pageable) {
        Page<Ticket> tickets = ticketService.obtenerTickets(pageable);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicketPorId(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.obtenerTicketPorId(id);
        return (ResponseEntity<Ticket>) ((Optional<?>) ticket).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
