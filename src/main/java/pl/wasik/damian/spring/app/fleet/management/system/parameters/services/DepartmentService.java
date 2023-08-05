package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Department;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //Get All Departments
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    //Get Department By Id
    public Department findById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    //Delete Department
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

    //Update Department
    public void save( Department department) {
        departmentRepository.save(department);
    }

}
