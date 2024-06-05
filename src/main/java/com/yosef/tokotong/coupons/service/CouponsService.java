package com.yosef.tokotong.coupons.service;

import com.yosef.tokotong.coupons.entity.Coupon;

import java.util.List;

public interface CouponsService {
  public List<Coupon> getCoupons();

  public Coupon createCoupon(Coupon coupon);
}
