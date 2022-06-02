package com.example.java_programming_test2.web;
import com.example.java_programming_test2.models1.Employee;
import com.example.java_programming_test2.request.EmployeeRequest;
import com.example.java_programming_test2.response.MessageResponse;
import com.example.java_programming_test2.service.EmployeeService;

import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/menu/items/")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
        Employee employee = employeeService.getASingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('create:employee')")
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest employee) {
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('update:employee')")

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateEmployee( @PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        MessageResponse updateEmployee = (MessageResponse) employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('delete:employee')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
