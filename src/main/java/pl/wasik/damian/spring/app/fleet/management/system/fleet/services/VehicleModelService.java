package pl.wasik.damian.spring.app.fleet.management.system.fleet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleModel;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories.VehicleModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> findAll() {
        return vehicleModelRepository.findAll();
    }

    public Optional<VehicleModel> findById(Long id) {
        return vehicleModelRepository.findById(id);
    }

    public void delete(Long id) {
        vehicleModelRepository.deleteById(id);
    }

    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

}
