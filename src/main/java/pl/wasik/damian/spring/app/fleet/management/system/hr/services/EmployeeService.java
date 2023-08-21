package pl.wasik.damian.spring.app.fleet.management.system.hr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.hr.models.Employee;
import pl.wasik.damian.spring.app.fleet.management.system.hr.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public void save( Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }

    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);
    }
}
