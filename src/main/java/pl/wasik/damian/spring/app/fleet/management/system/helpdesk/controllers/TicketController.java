package pl.wasik.damian.spring.app.fleet.management.system.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.models.Ticket;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.services.TicketService;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.services.TicketStatusService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.ClientService;

import java.util.Optional;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketStatusService ticketStatusService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/helpdesk/tickets")
    public String findAll(Model model) {
        model.addAttribute("tickets", ticketService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
        return "/helpdesk/tickets";
    }

    @GetMapping("/tickets/findById")
    public Optional<Ticket> findById(Long id) {
        return ticketService.findById(id);
    }

    @PostMapping("/tickets/addNew")
    public String addNew(Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/ticketList";
    }

    @GetMapping("/tickets/update")
    public String update(Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/ticketList";
    }

    @GetMapping("/tickets/delete")
    public String delete(Long id) {
        ticketService.delete(id);
        return "redirect:/ticketList";
    }
}