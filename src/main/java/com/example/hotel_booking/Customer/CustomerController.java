package com.example.hotel_booking.Customer;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

  @Autowired
  public CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("/create")
  public String createCustomer(@RequestBody Customer customer) throws InterruptedException, ExecutionException {
    return customerService.createCustomer(customer);
  }

  @GetMapping("/get")
  public Customer getCustomer(@RequestParam String customerId) throws InterruptedException, ExecutionException {
    return customerService.getCustomer(customerId);
  }

  @GetMapping("/get_email")
  public Customer getCustomerByEmail(@RequestParam String customerEmail)
      throws InterruptedException, ExecutionException {
    return customerService.getCustomerByEmail(customerEmail);
  }

  @PutMapping("/update")
  public String updateCustomer(@RequestBody Customer customer) throws InterruptedException, ExecutionException {
    return customerService.updateCustomer(customer);
  }

  @PutMapping("/delete")
  public String deleteCustomer(@RequestParam String customerEmail) throws InterruptedException, ExecutionException {
    return customerService.deleteCustomer(customerEmail);
  }

  @PostMapping("/test")
  public ResponseEntity<String> testGetEndpoint() {
    return ResponseEntity.ok("Test Get Endpoint is working");
  }
}
