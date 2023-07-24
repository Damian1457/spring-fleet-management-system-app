package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.State;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.StateService;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model) {
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    @GetMapping("/parameters/states")
    public String findAll(Model model) {
        addModelAttribute(model);
        return "/parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model) {
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Long id, @PathVariable String op, Model model) {
        addModelAttribute(model);
        model.addAttribute("state", stateService.findById(id));
        return "/parameters/state" + op;
    }

    @PostMapping("/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @GetMapping("/parameters/states/delete/{id}")
    public String delete(@PathVariable Long id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }
}
