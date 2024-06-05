package com.yosef.tokotong.payments;

import com.yosef.tokotong.payments.entity.Payment;
import com.yosef.tokotong.payments.service.PaymentsService;
import com.yosef.tokotong.response.Response;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
@Log
public class PaymentsController {
  private final PaymentsService paymentsService;

  public PaymentsController (PaymentsService paymentsService) {
    this.paymentsService = paymentsService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<Payment>>> getPayments () {
    return Response.successResponse("All Payments fetched", paymentsService.getPayments());
  }

  @PostMapping("/")
  public ResponseEntity<Response<Payment>> createPayment (@Validated @RequestBody Payment payment) {
    return Response.successResponse("Create payment success", paymentsService.createPayment(payment));
  }
}
