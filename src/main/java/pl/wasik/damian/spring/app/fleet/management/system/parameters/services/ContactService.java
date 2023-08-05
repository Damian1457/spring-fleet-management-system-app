package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Contact;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.ContactRepository;

import java.util.List;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//Get All Contacts
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}	
	
	//Get Contact By Id
	public Contact findById(int id) {
		return contactRepository.findById(id).orElse(null);
	}	
	
	//Delete Contact
	public void delete(int id) {
		contactRepository.deleteById(id);
	}
	
	//Update Contact
	public void save( Contact contact) {
		contactRepository.save(contact);
	}

}
