package pl.wasik.damian.spring.app.fleet.management.system.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.models.TicketStatus;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.services.TicketStatusService;

import java.util.Optional;

@Controller
public class TicketStatusController {

    @Autowired
    private TicketStatusService ticketStatusService;

    @GetMapping("/helpdesk/ticketStatuses")
    public String findAll(Model model) {
        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
        return "/helpdesk/ticketStatuses";
    }

    @GetMapping("/helpdesk/ticketStatus/{id}")
    public Optional<TicketStatus> findById(@PathVariable Long id) {
        return ticketStatusService.findById(id);
    }

    @PostMapping("/helpdesk/ticketStatuses")
    public String addNew(TicketStatus ticketStatus) {
        ticketStatusService.save(ticketStatus);
        return "redirect:/helpdesk/ticketStatuses";
    }

    @GetMapping("helpdesk/ticketStatus/delete/{id}")
    public String delete(@PathVariable Long id) {
        ticketStatusService.delete(id);
        return "redirect:/helpdesk/ticketStatuses";
    }
}