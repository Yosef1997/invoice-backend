package com.yosef.tokotong.payments.repository;

import com.yosef.tokotong.payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentsRepository extends JpaRepository<Payment, Long> {
  List<Payment> findByName(String name);
}
