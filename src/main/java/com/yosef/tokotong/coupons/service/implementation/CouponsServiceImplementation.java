package com.yosef.tokotong.coupons.service.implementation;

import com.yosef.tokotong.coupons.entity.Coupon;
import com.yosef.tokotong.coupons.repository.CouponsRepository;
import com.yosef.tokotong.coupons.service.CouponsService;
import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class CouponsServiceImplementation implements CouponsService {
  private final CouponsRepository couponsRepository;

  public CouponsServiceImplementation (CouponsRepository couponsRepository) {
    this.couponsRepository = couponsRepository;
  }


  @Override
  public List<Coupon> getCoupons() {
    return couponsRepository.findAll();
  }

  @Override
  public Coupon createCoupon(Coupon coupon) {
    var result = couponsRepository.findByName(coupon.getName());
    if (!result.isEmpty()) {
      throw new ApplicationException("Coupon name already exists");
    }
    return couponsRepository.save(coupon);
  }
}
