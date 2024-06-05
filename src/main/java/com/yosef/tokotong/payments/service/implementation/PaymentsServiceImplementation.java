package com.yosef.tokotong.payments.service.implementation;

import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import com.yosef.tokotong.payments.entity.Payment;
import com.yosef.tokotong.payments.repository.PaymentsRepository;
import com.yosef.tokotong.payments.service.PaymentsService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class PaymentsServiceImplementation implements PaymentsService {
  private final PaymentsRepository paymentsRepository;

  public PaymentsServiceImplementation (PaymentsRepository paymentsRepository) {
    this.paymentsRepository = paymentsRepository;
  }

  @Override
  public List<Payment> getPayments() {
    return paymentsRepository.findAll();
  }

  @Override
  public Payment createPayment(Payment payment) {
    var result = paymentsRepository.findByName(payment.getName());
    if (!result.isEmpty()) {
      throw new ApplicationException("Payment name already exists");
    }
    return paymentsRepository.save(payment);
  }
}
