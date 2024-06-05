package com.yosef.tokotong.orders.service;

import com.yosef.tokotong.orders.dto.CreateOrder;
import com.yosef.tokotong.orders.entity.Order;

import java.util.List;

public interface OrdersService {
  public List<Order> getOrders ();

  public Order createOrder (CreateOrder request);
}
