package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String getAll() {
        LOGGER.info("getAll()");
        List<Country> countries = countryService.getAll();
        return "/parameters/countryList";
    }
}