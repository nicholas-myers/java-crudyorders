package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;

import java.util.List;

public interface OrderService
{
   Order findOrderByNumber(long ordnum);
}
