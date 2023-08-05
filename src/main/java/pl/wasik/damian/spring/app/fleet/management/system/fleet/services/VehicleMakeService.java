package pl.wasik.damian.spring.app.fleet.management.system.fleet.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleMake;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories.VehicleMakeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//Get All VehicleMakes
	public List<VehicleMake> findAll(){
		return vehicleMakeRepository.findAll();
	}	
	
	//Get VehicleMake By Id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}	
	
	//Delete VehicleMake
	public void delete(int id) {
		vehicleMakeRepository.deleteById(id);
	}
	
	//Update VehicleMake
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

}
