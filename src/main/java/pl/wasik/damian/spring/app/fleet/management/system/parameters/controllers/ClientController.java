package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Client;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.ClientService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.StateService;

@Controller
public class ClientController {

    @Autowired	private ClientService clientService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/clients")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/clients";
    }

    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model){
        model.addAttribute("countries", countryService.findAll());
        return "parameters/clientAdd";
    }

    @GetMapping("/parameters/client/{op}/{id}")
    public String editClient(@PathVariable Long id, @PathVariable String op, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        addModelAttributes(model);
        return "/parameters/client"+ op;
    }

    @PostMapping("/parameters/clients")
    public String save(Client client) {
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

    @RequestMapping(value="/parameters/clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return "redirect:/parameters/clients";
    }
}