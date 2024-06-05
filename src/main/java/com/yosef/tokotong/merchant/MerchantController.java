package com.yosef.tokotong.merchant;

import com.yosef.tokotong.merchant.entity.Merchant;
import com.yosef.tokotong.merchant.service.MerchantService;
import com.yosef.tokotong.response.Response;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/merchant")
@Log
public class MerchantController {
  private final MerchantService merchantService;

  public MerchantController(MerchantService merchantService) {
    this.merchantService = merchantService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<Merchant>>> getMerchants() {
    return Response.successResponse("All merchants fetched", merchantService.getMerchants());
  }

  @PostMapping("/")
  public ResponseEntity<Response<Object>> createMerchant (@Validated @RequestBody Merchant merchant) {
    return Response.successResponse("Create merchant success", merchantService.createMerchant(merchant));
  }
}
