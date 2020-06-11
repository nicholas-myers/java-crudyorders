package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
   @Autowired
   private CustomerService customerService;


   @GetMapping(value = "/customers/orders",
           produces = {"application/json"})
   public ResponseEntity<?> listAllCustomers() {
      List<Customer> allCustomers = customerService.findAllCustomers();
      return new ResponseEntity<>(allCustomers, HttpStatus.OK);
   }

   @GetMapping(value = "/customers/customer/{custcode}",
           produces = {"application/json"})
   public ResponseEntity<?> getCustomerByCode(@PathVariable Long custcode) {
      Customer c = customerService.findCustomerByCode(custcode);
      return new ResponseEntity<>(c, HttpStatus.OK);
   }

   @GetMapping(value = "/customers/namelike/{custname}",
   produces = {"application/json"})
   public ResponseEntity<?> findCustomerByNameLike(@PathVariable String custname)
   {
      List<Customer> matchList = customerService.findCustomerByNameLike(custname);
      return new ResponseEntity<>(matchList, HttpStatus.OK);
   }

}
