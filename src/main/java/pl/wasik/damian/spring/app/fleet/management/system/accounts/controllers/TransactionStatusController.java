package pl.wasik.damian.spring.app.fleet.management.system.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.TransactionStatus;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.TransactionStatusService;

import java.util.List;

@Controller
public class TransactionStatusController {

    @Autowired
    private TransactionStatusService transactionStatusService;

    @GetMapping("/accounts/transactionStatuses")
    public String parameters(Model model) {
        List<TransactionStatus> transactionStatuses = transactionStatusService.findAll();
        model.addAttribute("transactionStatuses", transactionStatuses);
        return "/accounts/transactionStatuses";
    }

    @GetMapping("/accounts/transactionStatus/{id}")
    public TransactionStatus getById(@PathVariable Long id) {
        return transactionStatusService.findById(id).orElse(null);
    }

    @PostMapping("/accounts/transactionStatuses")
    public String save(TransactionStatus transactionStatus) {
        transactionStatusService.save(transactionStatus);
        return "redirect:/accounts/transactionStatuses";
    }

    @GetMapping("/accounts/transactionStatus/delete/{id}")
    public String delete(@PathVariable Long id) {
        transactionStatusService.delete(id);
        return "redirect:/accounts/transactionStatus";
    }
}
