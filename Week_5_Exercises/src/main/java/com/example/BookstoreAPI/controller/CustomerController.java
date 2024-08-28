package com.example.BookstoreAPI.controller;


import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.entity.Customer;
import com.example.BookstoreAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Endpoint to handle JSON request body
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Endpoint to handle form data
    @PostMapping("/register-form")
    public ResponseEntity<Map<String, String>> registerCustomerForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        
        customerRepository.save(customer);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Customer registered successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
