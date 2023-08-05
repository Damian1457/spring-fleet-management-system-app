package pl.wasik.damian.spring.app.fleet.management.system.fleet.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleHire;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories.VehicleHireRepository;

import java.util.List;

@Service
public class VehicleHireService {
	
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//Get All VehicleHires
	public List<VehicleHire> findAll(){
		return vehicleHireRepository.findAll();
	}	
	
	//Get VehicleHire By Id
	public VehicleHire findById(int id) {
		return vehicleHireRepository.findById(id).orElse(null);
	}	
	
	//Delete VehicleHire
	public void delete(int id) {
		vehicleHireRepository.deleteById(id);
	}
	
	//Update VehicleHire
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}

}
