package pl.wasik.damian.spring.app.fleet.management.system.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.Transaction;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.TransactionService;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.TransactionStatusService;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.services.TransactionTypeService;
import pl.wasik.damian.spring.app.fleet.management.system.hr.services.EmployeeService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.ClientService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.ContactService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.SupplierService;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionStatusService transactionStatusService;
    @Autowired
    private TransactionTypeService transactionTypeService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeService employeeService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("transactionStatuses", transactionStatusService.findAll());
        model.addAttribute("transactionTypes", transactionTypeService.findAll());
        model.addAttribute("contacts", contactService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return model;
    }

    @GetMapping("/accounts/transactions")
    public String getAll(Model model) {
        List<Transaction> transactions = transactionService.findAll();
        model.addAttribute("transactions", transactions);
        addModelAttributes(model);
        return "/accounts/transactions";
    }

    @GetMapping("/accounts/transactionAdd")
    public String addTransaction(Model model) {
        addModelAttributes(model);
        return "accounts/transactionAdd";
    }

    @GetMapping("/accounts/transaction/{op}/{id}")
    public String editTransaction(@PathVariable Long id, @PathVariable String op, Model model) {
        Transaction transaction = transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        addModelAttributes(model);
        return "/accounts/transaction" + op;
    }

    @PostMapping("/accounts/transactions")
    public String save(Transaction transaction) {
        transactionService.save(transaction);
        return "redirect:/accounts/transactions";
    }

    @GetMapping("/accounts/transactions/delete/{id}")
    public String delete(@PathVariable Long id) {
        transactionService.delete(id);
        return "redirect:/accounts/transactions";
    }
}
