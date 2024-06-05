package com.yosef.tokotong.orders;

import com.yosef.tokotong.orders.dto.CreateOrder;
import com.yosef.tokotong.orders.entity.Order;
import com.yosef.tokotong.orders.service.OrdersService;
import com.yosef.tokotong.response.Response;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@Log
public class OrdersController {
  private final OrdersService ordersService;

  public OrdersController (OrdersService ordersService) {
    this.ordersService = ordersService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<Order>>> getOrders () {
    return Response.successResponse("All orders fetch", ordersService.getOrders());
  }

  @PostMapping("/")
  public ResponseEntity<Response<Order>> createOrder (@Validated @RequestBody CreateOrder request) {
    return Response.successResponse("Create order success", ordersService.createOrder(request));
  }
}
