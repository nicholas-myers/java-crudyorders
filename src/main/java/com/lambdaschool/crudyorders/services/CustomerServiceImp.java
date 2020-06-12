package com.lambdaschool.crudyorders.services;


import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
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
      Customer newCustomer = new Customer();
      if (customer.getCustcode() != 0) {
         custrepos.findById(customer.getCustcode())
                 .orElseThrow(() -> new EntityNotFoundException("Customer " + customer.getCustcode() + " Not Found"));

         newCustomer.setCustcode(customer.getCustcode());
      }


      newCustomer.setCustname(customer.getCustname());
      newCustomer.setCustcity(customer.getCustcity());
      newCustomer.setWorkingarea(customer.getWorkingarea());
      newCustomer.setCustcountry(customer.getCustcountry());
      newCustomer.setGrade(customer.getGrade());
      newCustomer.setOpeningamt(customer.getOpeningamt());
      newCustomer.setReceiveamt(customer.getReceiveamt());
      newCustomer.setPaymentamt(customer.getPaymentamt());
      newCustomer.setOutstandingamt(customer.getOutstandingamt());
      newCustomer.setPhone(customer.getPhone());
      newCustomer.setAgent(customer.getAgent());

      newCustomer.getOrders().clear();
      for (Order o : customer.getOrders()) {
         Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), o.getOrderdescription(), o.getPayments());
         newCustomer.getOrders().add(newOrder);
      }
      return custrepos.save(newCustomer);
   }

   @Transactional
   @Override
   public Customer update(Customer customer, long custcode) {
      return null;
   }
}
