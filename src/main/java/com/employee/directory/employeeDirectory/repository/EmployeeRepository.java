package com.employee.directory.employeeDirectory.repository;

import com.employee.directory.employeeDirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByLastNameAsc();
    //List<Employee> findByNameIn(List<String> names);
    List<Employee> findByFirstName(String name);
    List<Employee> findByFirstNameAndLastName(String firstname, String lastname);
}