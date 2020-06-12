package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService
{
   List<Customer> findAllCustomers();

   Customer findCustomerByCode(long custcode);

   List<Customer> findCustomerByNameLike(String customername);

   //post

   //delete
   void delete(long custcode);


   //handles post and put
   Customer save(Customer customer);

   //patch
   Customer update(Customer customer, long custcode);
}
