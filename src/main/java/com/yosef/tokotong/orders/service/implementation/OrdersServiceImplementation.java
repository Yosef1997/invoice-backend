package com.yosef.tokotong.orders.service.implementation;

import com.yosef.tokotong.coupons.entity.Coupon;
import com.yosef.tokotong.coupons.repository.CouponsRepository;
import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import com.yosef.tokotong.merchant.entity.Merchant;
import com.yosef.tokotong.merchant.repository.MerchantRepository;
import com.yosef.tokotong.orders.dto.CreateOrder;
import com.yosef.tokotong.orders.entity.*;
import com.yosef.tokotong.orders.repository.OrdersRepository;
import com.yosef.tokotong.orders.service.OrdersService;
import com.yosef.tokotong.payments.entity.Payment;
import com.yosef.tokotong.payments.repository.PaymentsRepository;
import com.yosef.tokotong.products.entity.Product;
import com.yosef.tokotong.products.repository.ProductRepository;
import com.yosef.tokotong.shipments.entity.Shipment;
import com.yosef.tokotong.shipments.repository.ShipmentsRepository;
import com.yosef.tokotong.user.entity.User;
import com.yosef.tokotong.user.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class OrdersServiceImplementation implements OrdersService {
  private final OrdersRepository ordersRepository;
  private final UserRepository userRepository;
  private final MerchantRepository merchantRepository;
  private final ShipmentsRepository shipmentsRepository;
  private final ProductRepository productRepository;
  private final PaymentsRepository paymentsRepository;
  private final CouponsRepository couponsRepository;

  public OrdersServiceImplementation(
          OrdersRepository ordersRepository,
          UserRepository userRepository,
          MerchantRepository merchantRepository,
          ShipmentsRepository shipmentsRepository,
          ProductRepository productRepository,
          PaymentsRepository paymentsRepository,
          CouponsRepository couponsRepository
  ) {
    this.ordersRepository = ordersRepository;
    this.userRepository = userRepository;
    this.merchantRepository = merchantRepository;
    this.shipmentsRepository = shipmentsRepository;
    this.productRepository = productRepository;
    this.paymentsRepository = paymentsRepository;
    this.couponsRepository = couponsRepository;
  }


  @Override
  public List<Order> getOrders() {
    var result = ordersRepository.findAll();
    if (result.isEmpty()) {
      throw new ApplicationException("Orders is empty");
    }
    return ordersRepository.findAll();
  }

  @Override
  public Order createOrder(CreateOrder request) {
    Order order = new Order();
    var result = ordersRepository.findByInvoice(request.getInvoice());
    if (!result.isEmpty()) {
      throw new ApplicationException("Invoice already exists");
    }
    order.setInvoice(request.getInvoice());

    User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
    order.setUser(user);

    Merchant merchant = merchantRepository.findById(request.getMerchantId())
            .orElseThrow(() -> new RuntimeException("Merchant not found"));
    order.setMerchant(merchant);

    Shipment shipment = shipmentsRepository.findById(request.getShipmentId())
            .orElseThrow(() -> new RuntimeException("Shipment not found"));
    order.setShipment(shipment);

    order.setOrderAmount(request.getOrderAmount());
    order.setInsurance(request.getIsInsurance());
    order.setInsuranceFee(request.getInsuranceFee());
    order.setShippingFee(request.getShippingFee());
    order.setAppFee(request.getAppFee());
    order.setServiceFee(request.getServiceFee());

    List<Product> products = productRepository.findAllById(request.getProductIds());
    order.setProducts(products);

    List<Payment> payments = paymentsRepository.findAllById(request.getPaymentIds());
    order.setPayments(payments);

    List<Coupon> coupons = couponsRepository.findAllById(request.getCouponIds());
    order.setCoupons(coupons);

    return ordersRepository.save(order);
  }
}
