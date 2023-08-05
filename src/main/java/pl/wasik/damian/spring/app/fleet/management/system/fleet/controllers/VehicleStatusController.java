package pl.wasik.damian.spring.app.fleet.management.system.fleet.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleStatus;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.services.VehicleStatusService;

import java.util.Optional;

@Controller
public class VehicleStatusController {
	
	@Autowired private VehicleStatusService vehicleStatusService;
	
	//Get All VehicleStatuss
	@GetMapping("/fleet/vehicleStatuses")
	public String findAll(Model model){		
		model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
		return "/fleet/vehicleStatuses";
	}	
	
	@RequestMapping("/fleet/vehicleStatus/{id}")
	@ResponseBody
	public Optional<VehicleStatus> findById(@PathVariable Integer id)
	{
		return vehicleStatusService.findById(id);
	}
	
	//Add VehicleStatus
	@PostMapping(value="/fleet/vehicleStatuses")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/fleet/vehicleStatuses";
	}	

	@RequestMapping(value="fleet/vehicleStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/fleet/vehicleStatuses";
	}
}
