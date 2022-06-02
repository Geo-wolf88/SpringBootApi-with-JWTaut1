package com.example.java_programming_test2.service;
import org.springframework.stereotype.Component;
import com.example.java_programming_test2.models1.Employee;
import com.example.java_programming_test2.request.EmployeeRequest;
import com.example.java_programming_test2.response.MessageResponse;
import java.util.List;

@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Object updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Integer employeeId);
    Employee getASingleEmployee(Integer employeeId);
    List<Employee> getAllEmployee();

}
