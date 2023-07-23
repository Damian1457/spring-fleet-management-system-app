package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Location;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return (List<Location>) locationRepository.findAll();
    }

    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findByDescriptionContaining(String description) {
        return null;
    }
}
