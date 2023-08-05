package pl.wasik.damian.spring.app.fleet.management.system.fleet.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleMake;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.services.VehicleMakeService;

import java.util.Optional;

@Controller
public class VehicleMakeController {
	
	@Autowired private VehicleMakeService vehicleMakeService;
	
	//Get All VehicleMakes
	@GetMapping("fleet/vehicleMakes")
	public String findAll(Model model){		
		model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
		return "/fleet/vehicleMakes";
	}	
	
	@RequestMapping("/fleet/vehicleMakes/{id}")
	@ResponseBody
	public Optional<VehicleMake> findById(@PathVariable Integer id)
	{
		return vehicleMakeService.findById(id);
	}
	
	//Add VehicleMake
	@PostMapping(value="/fleet/vehicleMakes")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/fleet/vehicleMakes";
	}
	
	@RequestMapping(value="vehicleMake/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/fleet/vehicleMakes";
	}
}
