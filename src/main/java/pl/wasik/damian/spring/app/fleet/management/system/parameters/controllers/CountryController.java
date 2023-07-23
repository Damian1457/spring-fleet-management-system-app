package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/parameters/countries")
    public String getAllPages(Model model) {
        return getOnePage(model, 1);
    }

    @GetMapping("/parameters/countries/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Country> page = countryService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Country> countries = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("countries", countries);

        return "/parameters/countries";
    }

    @GetMapping("/parameters/countries/page/{pageNumber}/{field}")
    public String getPageWithSort(Model model,
                                  @PathVariable("pageNumber") int currentPage,
                                  @PathVariable String field,
                                  @PathParam("sortDir") String sortDir) {

        Page<Country> page = countryService.findAllWithSort(field, sortDir, currentPage);
        List<Country> countries = page.getContent();
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("countries", countries);
        return "/parameters/countries";
    }

    @GetMapping("/parameters/country/{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @GetMapping("/parameters/countryAdd")
    public String addCountry() {
        return "parameters/countryAdd";
    }

    @GetMapping("/parameters/country/{op}/{id}")
    public String editCountry(@PathVariable Long id, @PathVariable String op, Model model) {
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "/parameters/country" + op;
    }

    @PostMapping("/parameters/countries")
    public String save(Country country) {
        countryService.save(country);
        return "redirect:/parameters/countries";
    }

    @GetMapping("/parameters/countries/delete/{id}")
    public String delete(@PathVariable Long id) {
        countryService.delete(id);
        return "redirect:/parameters/countries";
    }

}