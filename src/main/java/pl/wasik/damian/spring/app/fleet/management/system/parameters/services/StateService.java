package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.State;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.StateRepository;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public State findById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }
    
    public void delete(Long id) {
        stateRepository.deleteById(id);
    }

    public void save(State state) {
        stateRepository.save(state);
    }
}
