package pl.wasik.damian.spring.app.fleet.management.system.fleet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleType;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories.VehicleTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleType> findById(Long id) {
        return vehicleTypeRepository.findById(id);
    }

    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public void delete(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}
