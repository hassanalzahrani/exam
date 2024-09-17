package com.example.exam3.SERVICE;

import com.example.exam3.Model.Employee;
import com.example.exam3.REPOSITORY.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    public void update(Integer employeeId, Employee employee) {
        Employee employee1 = employeeRepository.findEmployeeById(employeeId);
        if (employee1 == null) {
            throw new RuntimeException("Employee not found");
        }
        if (employee1.getId() != employee.getId()) {
            throw new RuntimeException("Employee id mismatch");
        }
        employeeRepository.save(employee);

    }
}
