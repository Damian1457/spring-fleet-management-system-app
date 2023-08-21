package pl.wasik.damian.spring.app.fleet.management.system.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.hr.models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String un);

    @Query(value = "select * from Employee e where e.firstname like %:keyword% or e.lastname like %:keyword%", nativeQuery = true)
    List<Employee> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT city, count(*) FROM Employee GROUP BY city",
            nativeQuery = true)
    List<Object> getCountByCountry();
}