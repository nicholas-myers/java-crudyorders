package com.lambdaschool.crudyorders.services;


import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImp implements CustomerService
{
   @Autowired
   private CustomerRepository custrepos;

   @Override
   public List<Customer> findAllCustomers()
   {
      List<Customer> list = new ArrayList<>();

      custrepos.findAll()
              .iterator()
              .forEachRemaining(list::add);
      return list;
   }

   @Override
   public Customer findCustomerByCode(long custcode)
      throws EntityNotFoundException
   {
      return custrepos.findById(custcode)
              .orElseThrow(() -> new EntityNotFoundException("Customer " + custcode + " Not Found"));
   }

   @Override
   public List<Customer> findCustomerByNameLike(String customername)
   {
      ArrayList<Customer> list = custrepos.findByCustnameContainingIgnoringCase(customername);
      return list;
   }

   @Transactional
   @Override
   public void delete(long custcode) {
      if (custrepos.findById(custcode).isPresent()) {
         custrepos.deleteById(custcode);
      } else {
         throw new EntityNotFoundException("Restaurant " + custcode + " Not Found");
      }
   }

   @Transactional
   @Override
   public Customer save(Customer customer) {
      return null;
   }

   @Transactional
   @Override
   public Customer update(Customer customer, long custcode) {
      return null;
   }
}
