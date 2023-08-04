package pl.wasik.damian.spring.app.fleet.management.system.fleet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleModel;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.services.VehicleModelService;

import java.util.Optional;

public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("fleet/vehicleModels")
    public String findAll(Model model) {
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        return "/fleet/vehicleModels";
    }

    @RequestMapping("/fleet/vehicleModel/{id}")
    @ResponseBody
    public Optional<VehicleModel> findById(@PathVariable Long id) {
        return vehicleModelService.findById(id);
    }

    @PostMapping("/fleet/vehicleModels")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/fleet/vehicleModels";
    }

    @GetMapping("vehicleModel/delete/{id}")
    public String delete(@PathVariable Long id) {
        vehicleModelService.delete(id);
        return "redirect:/fleet/vehicleModels";
    }
}
