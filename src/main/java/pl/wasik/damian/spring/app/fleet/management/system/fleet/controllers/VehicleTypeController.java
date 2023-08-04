package pl.wasik.damian.spring.app.fleet.management.system.fleet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleType;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.services.VehicleTypeService;

import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/fleet/vehicleTypes")
    public String findAll(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        return "/fleet/vehicleTypes";
    }

    @RequestMapping("/fleet/vehicleType/{id}")
    @ResponseBody
    public Optional<VehicleType> findById(@PathVariable Long id) {
        return vehicleTypeService.findById(id);
    }

    @PostMapping("/fleet/vehicleTypes")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/fleet/vehicleTypes";
    }

    @GetMapping("fleet/vehicleType/delete/{id}")
    public String delete(@PathVariable Long id) {
        vehicleTypeService.delete(id);
        return "redirect:/fleet/vehicleTypes";
    }
}
