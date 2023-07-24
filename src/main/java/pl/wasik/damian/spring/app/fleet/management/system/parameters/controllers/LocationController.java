package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Location;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.LocationService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.StateService;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/locations")
    public String findAll(Model model) {
        addModelAttributes(model);
        return "/parameters/locations";
    }

    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "parameters/locationAdd";
    }

    @GetMapping("/parameters/location/{op}/{id}")
    public String editLocation(@PathVariable Long id, @PathVariable String op, Model model) {
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        addModelAttributes(model);
        return "/parameters/location" + op; //returns locationEdit or locationDetails
    }

    @PostMapping("/parameters/locations")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    @RequestMapping("/parameters/location/delete/{id}")
    public String delete(@PathVariable Long id) {
        locationService.deleteById(id);
        return "redirect:/parameters/locations";
    }
}