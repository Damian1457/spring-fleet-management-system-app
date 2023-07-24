package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Client;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }
}