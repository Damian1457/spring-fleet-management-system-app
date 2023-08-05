package pl.wasik.damian.spring.app.fleet.management.system.fleet.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.Vehicle;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories.VehicleRepository;

import java.util.List;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	//Get All Vehicles
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}	
	
	//Get Vehicle By Id
	public Vehicle findById(int id) {
		return vehicleRepository.findById(id).orElse(null);
	}	
	
	//Delete Vehicle
	public void delete(int id) {
		vehicleRepository.deleteById(id);
	}
	
	//Update Vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

}
