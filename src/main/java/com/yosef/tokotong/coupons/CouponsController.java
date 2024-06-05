package com.yosef.tokotong.coupons;

import com.yosef.tokotong.coupons.entity.Coupon;
import com.yosef.tokotong.coupons.service.CouponsService;
import com.yosef.tokotong.response.Response;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coupon")
@Log
public class CouponsController {
  private final CouponsService couponsService;

  public CouponsController (CouponsService couponsService) {
    this.couponsService = couponsService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<Coupon>>> getCoupons () {
    return Response.successResponse("All Coupons fetched", couponsService.getCoupons());
  }

  @PostMapping("/")
  public ResponseEntity<Response<Coupon>> createCoupon (@RequestBody Coupon coupon) {
    return Response.successResponse("All Coupons fetched", couponsService.createCoupon(coupon));
  }
}
