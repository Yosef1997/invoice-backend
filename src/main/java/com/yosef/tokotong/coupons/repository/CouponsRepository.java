package com.yosef.tokotong.coupons.repository;

import com.yosef.tokotong.coupons.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponsRepository extends JpaRepository<Coupon, Long> {
  List<Coupon> findByName(String name);
}
