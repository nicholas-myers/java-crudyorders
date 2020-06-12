package com.lambdaschool.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long ordnum;

   @Column(nullable = false)
   private double ordamount;
   private double advanceamount;

   @ManyToOne
   @JoinColumn(name = "custcode", nullable = false)
   @JsonIgnoreProperties(value = "customer")
   private Customer customer;

   private String orderdescription;

   @ManyToMany
   @JoinTable(name = "orderspayments",
           joinColumns = @JoinColumn(name = "ordnum"),
           inverseJoinColumns = @JoinColumn(name = "paymentid"))
   private List<Payment> payments = new ArrayList<>();


   public Order() {
   }

   public Order(double ordamount, double advanceamount, String orderdescription, List<Payment> payments) {

      this.ordamount = ordamount;
      this.advanceamount = advanceamount;
      this.orderdescription = orderdescription;
      this.payments = payments;
   }

   public long getOrdnum() {
      return ordnum;
   }

   public void setOrdnum(long ordnum) {
      this.ordnum = ordnum;
   }

   public double getOrdamount() {
      return ordamount;
   }

   public void setOrdamount(double ordamount) {
      this.ordamount = ordamount;
   }

   public double getAdvanceamount() {
      return advanceamount;
   }

   public void setAdvanceamount(double advanceamount) {
      this.advanceamount = advanceamount;
   }

   public String getOrderdescription() {
      return orderdescription;
   }

   public void setOrderdescription(String orderdescription) {
      this.orderdescription = orderdescription;
   }

   public List<Payment> getPayments() {
      return payments;
   }

   public void setPayments(List<Payment> payments) {
      this.payments = payments;
   }

   @Override
   public String toString() {
      return "Order{" +
              "ordnum=" + ordnum +
              ", ordamount=" + ordamount +
              ", advanceamount=" + advanceamount +
              ", customer=" + customer +
              ", orderdescription='" + orderdescription + '\'' +
              ", payments=" + payments +
              '}';
   }
}
