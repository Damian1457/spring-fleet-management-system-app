package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.CountryRepository;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
