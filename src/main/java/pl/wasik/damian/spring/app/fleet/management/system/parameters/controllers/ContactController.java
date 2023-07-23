package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Contact;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.ContactService;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/parameters/contacts")
    public String getAll(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "/parameters/contacts";
    }

    @GetMapping("/parameters/contact/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("/parameters/contactAdd")
    public String addContact() {
        return "parameters/contactAdd";
    }

    @GetMapping("/parameters/contact/{op}/{id}")
    public String editContact(@PathVariable Long id, @PathVariable String op, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "/parameters/contact" + op;
    }

    @PostMapping("/parameters/contacts")
    public String save(Contact contact) {
        contactService.save(contact);
        return "redirect:/parameters/contacts";
    }

    @GetMapping("/parameters/contacts/delete/{id}")
    public String delete(@PathVariable Long id) {
        contactService.delete(id);
        return "redirect:/parameters/contacts";
    }
}