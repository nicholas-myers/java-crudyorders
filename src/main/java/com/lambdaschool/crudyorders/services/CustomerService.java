package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;

import java.util.List;

public interface CustomerService
{
   List<Customer> findAllCustomers();

   Customer findCustomerByCode(long custcode);

   List<Customer> findCustomerByNameLike(String customername);
}
