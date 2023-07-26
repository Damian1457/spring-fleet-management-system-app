package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Supplier;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.CountryService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.StateService;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.SupplierService;

@Controller
public class SupplierControler {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/suppliers")
    public String findAll(Model model) {
        addModelAttributes(model);
        return "/parameters/suppliers";
    }

    @GetMapping("/parameters/supplierAdd")
    public String addSupplier(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "parameters/supplierAdd";
    }

    @GetMapping("/parameters/supplier/{op}/{id}")
    public String editSupplier(@PathVariable Long id, @PathVariable String op, Model model) {
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        addModelAttributes(model);
        return "/parameters/supplier" + op;
    }

    @PostMapping("/parameters/suppliers")
    public String save(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }

    @GetMapping("/parameters/suppliers/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        supplierService.deleteById(id);
        return "redirect:/parameters/suppliers";
    }
}
