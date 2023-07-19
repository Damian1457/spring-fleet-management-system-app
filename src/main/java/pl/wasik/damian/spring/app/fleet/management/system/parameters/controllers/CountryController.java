package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class CountryController {

    private final static Logger LOGGER = Logger.getLogger(CountryController.class.getName());

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model) {
        LOGGER.info("getAll()");
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "parameters/countryList";
    }

    @GetMapping("/countryAdd")
    public String addCountry() {
        LOGGER.info("addCountry()");
        return "parameters/countryAdd";
    }

    @PostMapping("/countries")
    public String save(Country country) {
        LOGGER.info("save()");
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry(@PathVariable Long id, Model model) {
        LOGGER.info("editCountry()");
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryEdit";
    }

    @PostMapping("/countries/update/{id}")
    public String edit(Country country) {
        LOGGER.info("edit()");
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countryDetails/{id}")
    public String detailsCountry(@PathVariable Long id, Model model) {
        LOGGER.info("detailsCountry()");
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryDetails";
    }

    @GetMapping("/countries/delete/{id}")
    public String delete(@PathVariable Long id) {
        LOGGER.info("delete()");
        countryService.delete(id);
        return "redirect:/countries";
    }
}
