package com.yosef.tokotong.orders.entity;

import com.yosef.tokotong.coupons.entity.Coupon;
import com.yosef.tokotong.merchant.entity.Merchant;
import com.yosef.tokotong.payments.entity.Payment;
import com.yosef.tokotong.products.entity.Product;
import com.yosef.tokotong.shipments.entity.Shipment;
import com.yosef.tokotong.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_list")
@NoArgsConstructor
@Getter
@Setter
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Invoice is required")
  private String invoice;

  @NotNull(message = "User ID is required")
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  @NotNull(message = "Merchant ID is required")
  @ManyToOne
  @JoinColumn(name = "merchant_id", referencedColumnName = "id", nullable = false)
  private Merchant merchant;

  @NotNull(message = "Shipment ID is required")
  @ManyToOne
  @JoinColumn(name = "shipment_id",referencedColumnName = "id", nullable = false)
  private Shipment shipment;

  @DecimalMin(value = "0.0", message = "Order amount must be non-negative")
  private BigDecimal orderAmount;

  @NotNull(message = "Insurance is required")
  private boolean isInsurance;

  @DecimalMin(value = "0.0", message = "Insurance fee must be non-negative")
  private BigDecimal insuranceFee;

  @DecimalMin(value = "0.0", message = "Shipping fee must be non-negative")
  private BigDecimal shippingFee;

  @DecimalMin(value = "0.0", message = "App fee must be non-negative")
  private BigDecimal appFee;

  @DecimalMin(value = "0.0", message = "Service fee must be non-negative")
  private BigDecimal serviceFee;

  @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createdAt;

  @Column(nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updatedAt;

  @ManyToMany
  @JoinTable(
          name = "orderProducts",
          joinColumns = @JoinColumn(name = "orderId"),
          inverseJoinColumns = @JoinColumn(name = "productId")
  )
  private List<Product> products;

  @ManyToMany
  @JoinTable(
          name = "orderPayments",
          joinColumns = @JoinColumn(name = "orderId"),
          inverseJoinColumns = @JoinColumn(name = "paymentId")
  )
  private List<Payment> payments;

  @ManyToMany
  @JoinTable(
          name = "orderCoupons",
          joinColumns = @JoinColumn(name = "orderId"),
          inverseJoinColumns = @JoinColumn(name = "couponId")
  )
  private List<Coupon> coupons;
}
