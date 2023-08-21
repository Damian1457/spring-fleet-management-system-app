package pl.wasik.damian.spring.app.fleet.management.system.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.InvoiceStatus;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.InvoiceStatusService;

import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/accounts/invoiceStatuses")
    public String findAll(Model model) {
        model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
        return "/accounts/invoiceStatuses";
    }

    @GetMapping("/accounts/invoiceStatus/{id}")
    public Optional<InvoiceStatus> findById(@PathVariable Long id) {
        return invoiceStatusService.findById(id);
    }

    @PostMapping("/accounts/invoiceStatuses")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/accounts/invoiceStatuses";
    }

    @GetMapping("accounts/invoiceStatus/delete")
    public String delete(@PathVariable Long id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
