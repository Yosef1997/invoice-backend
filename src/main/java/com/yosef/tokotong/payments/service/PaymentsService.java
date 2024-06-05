package com.yosef.tokotong.payments.service;

import com.yosef.tokotong.payments.entity.Payment;

import java.util.List;

public interface PaymentsService {
  public List<Payment> getPayments ();

  public Payment createPayment(Payment payment);
}
