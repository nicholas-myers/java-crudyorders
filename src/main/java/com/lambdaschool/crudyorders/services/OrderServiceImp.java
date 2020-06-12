package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service(value = "orderService")
public class OrderServiceImp implements OrderService {
   @Autowired
   private OrderRepository ordersrepos;

   @Override
   public Order findOrderByNumber(long ordnum)
           throws EntityNotFoundException {
      return ordersrepos.findById(ordnum)
              .orElseThrow(() -> new EntityNotFoundException("Order " + ordnum + " Not Found"));
   }
}
