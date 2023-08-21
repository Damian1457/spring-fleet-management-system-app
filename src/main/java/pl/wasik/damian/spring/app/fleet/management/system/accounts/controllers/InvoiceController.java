package pl.wasik.damian.spring.app.fleet.management.system.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.Invoice;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.InvoiceService;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.InvoiceStatusService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.ClientService;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @Autowired
    private ClientService clientService;


    @GetMapping("/accounts/invoices")
    public String getAll(Model model) {
        List<Invoice> invoices = invoiceService.findAll();
        model.addAttribute("invoices", invoices);
        return "/accounts/invoices";
    }

    @GetMapping("/accounts/invoiceAdd")
    public String addInvoice() {
        return "accounts/invoiceAdd";
    }

    @GetMapping("/accounts/invoice/{op}/{id}")
    public String editInvoice(@PathVariable Long id, @PathVariable String op, Model model) {
        Invoice invoice = invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        return "/accounts/invoice" + op;
    }

    @PostMapping("/accounts/invoices")
    public String save(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/accounts/invoices";
    }

    @GetMapping("/accounts/invoices/delete/{id}")
    public String delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return "redirect:/accounts/invoices";
    }
}
