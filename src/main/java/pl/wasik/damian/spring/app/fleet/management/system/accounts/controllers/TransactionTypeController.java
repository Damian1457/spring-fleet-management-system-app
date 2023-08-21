package pl.wasik.damian.spring.app.fleet.management.system.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.TransactionType;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.TransactionTypeService;

import java.util.List;

@Controller
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/accounts/transactionTypes")
    public String parameters(Model model) {
        List<TransactionType> transactionTypes = transactionTypeService.findAll();
        model.addAttribute("transactionTypes", transactionTypes);
        return "accounts/transactionTypes";
    }

    @GetMapping("/accounts/transactionType/{id}")
    public TransactionType getById(@PathVariable Long id) {
        return transactionTypeService.findById(id).orElse(null);
    }

    @PostMapping("/accounts/transactionTypes")
    public String addNew(TransactionType transactionType) {
        transactionTypeService.save(transactionType);
        return "redirect:/accounts/transactionTypes";
    }

    @GetMapping("/accounts/transactionType/delete/{id}")
    public String delete(@PathVariable Long id) {
        transactionTypeService.delete(id);
        return "redirect:/accounts/transactionTypes";
    }
}
