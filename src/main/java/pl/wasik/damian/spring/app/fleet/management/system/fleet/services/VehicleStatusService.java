package pl.wasik.damian.spring.app.fleet.management.system.fleet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleStatus;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories.VehicleStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> findAll() {
        return vehicleStatusRepository.findAll();
    }

    public Optional<VehicleStatus> findById(Long id) {
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Long id) {
        vehicleStatusRepository.deleteById(id);
    }

    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

}
