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

    public List<VehicleMake> findAll() {
        return vehicleMakeRepository.findAll();
    }

    public Optional<VehicleMake> findById(Long id) {
        return vehicleMakeRepository.findById(id);
    }

    public void delete(Long id) {
        vehicleMakeRepository.deleteById(id);
    }

    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }
}
