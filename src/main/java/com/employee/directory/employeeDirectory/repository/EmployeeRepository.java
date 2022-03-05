package com.employee.directory.employeeDirectory.repository;

import com.employee.directory.employeeDirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}