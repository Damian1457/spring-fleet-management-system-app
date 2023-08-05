package pl.wasik.damian.spring.app.fleet.management.system.parameters.restapis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @CrossOrigin
    @GetMapping("/api/parameters/countries")
    public List<Country> getAll(Model model) {
        List<Country> countries = countryService.findAll();
        return countries;
    }
}
