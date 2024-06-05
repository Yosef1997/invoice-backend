package com.yosef.tokotong.orders.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CreateOrder {
  private String invoice;
  private Long userId;
  private Long merchantId;
  private Long shipmentId;
  private BigDecimal orderAmount;
  private Boolean isInsurance;
  private BigDecimal insuranceFee;
  private BigDecimal shippingFee;
  private BigDecimal appFee;
  private BigDecimal serviceFee;
  private List<Long> productIds;
  private List<Long> paymentIds;
  private List<Long> couponIds;
}
