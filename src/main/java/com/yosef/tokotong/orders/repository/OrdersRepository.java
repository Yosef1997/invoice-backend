package com.yosef.tokotong.orders.repository;

import com.yosef.tokotong.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Long> {
  List<Order> findByInvoice(String invoice);
}
