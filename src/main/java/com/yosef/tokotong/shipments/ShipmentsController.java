package com.yosef.tokotong.shipments;

import com.yosef.tokotong.response.Response;
import com.yosef.tokotong.shipments.entity.Shipment;
import com.yosef.tokotong.shipments.service.ShipmentsService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shipment")
@Log
public class ShipmentsController {
  private final ShipmentsService shipmentsService;

  public ShipmentsController (ShipmentsService shipmentsService) {
    this.shipmentsService = shipmentsService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<Shipment>>> getShipments () {
    return Response.successResponse("All shipments fetched", shipmentsService.getShipments());
  }

  @PostMapping("/")
  public ResponseEntity<Response<Shipment>> createShipment (@Validated @RequestBody Shipment shipment) {
    return Response.successResponse("Create shipment success", shipmentsService.createShipment(shipment));
  }

}
