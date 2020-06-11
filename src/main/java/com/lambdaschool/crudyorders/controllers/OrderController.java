package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.CustomerService;
import com.lambdaschool.crudyorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController
{
   @Autowired
   private OrderService orderService;

   @GetMapping(value = "/orders/order/{ordnum}",
           produces = {"application/json"})
   public ResponseEntity<?> getCustomerByCode(@PathVariable Long ordnum) {
      Order o = orderService.findOrderByNumber(ordnum);
      return new ResponseEntity<>(o, HttpStatus.OK);
   }

}
