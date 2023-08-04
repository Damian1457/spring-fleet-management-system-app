package pl.wasik.damian.spring.app.fleet.management.system.fleet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.Vehicle;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.services.*;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.services.LocationService;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private LocationService locationService;
//    @Autowired
//    private EmployeeService employeeService;
    @Autowired
    private VehicleStatusService vehicleStatusService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        model.addAttribute("locations", locationService.findAll());
//        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
        return model;
    }

    @GetMapping("/fleet/vehicles")
    public String findAll(Model model) {
        addModelAttributes(model);
        return "/fleet/vehicles";
    }

    @GetMapping("/fleet/vehicleAdd")
    public String addVehicle(Model model) {
        addModelAttributes(model);
        return "fleet/vehicleAdd";
    }

    @GetMapping("/fleet/vehicle/{op}/{id}")
    public String editVehicle(@PathVariable Long id, @PathVariable String op, Model model) {
        Vehicle vehicle = vehicleService.findById(id);
        model.addAttribute("vehicle", vehicle);
        addModelAttributes(model);
        return "/fleet/vehicle" + op;
    }

    @PostMapping("/fleet/vehicles")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/fleet/vehicles";
    }

    @GetMapping("/fleet/vehicle/delete/{id}")
    public String delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return "redirect:/fleet/vehicles";
    }
}
