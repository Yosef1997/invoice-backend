package com.yosef.tokotong.shipments.service.implementation;

import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import com.yosef.tokotong.shipments.entity.Shipment;
import com.yosef.tokotong.shipments.repository.ShipmentsRepository;
import com.yosef.tokotong.shipments.service.ShipmentsService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class ShipmentsServiceImplementation implements ShipmentsService {
  private final ShipmentsRepository shipmentsRepository;

  public ShipmentsServiceImplementation (ShipmentsRepository shipmentsRepository) {
    this.shipmentsRepository = shipmentsRepository;
  }

  @Override
  public List<Shipment> getShipments() {
    return shipmentsRepository.findAll();
  }

  @Override
  public Shipment createShipment(Shipment shipment) {
    var result = shipmentsRepository.findByName(shipment.getName());
    if (!result.isEmpty()) {
      throw new ApplicationException("Shipment name already exists");
    }
    return shipmentsRepository.save(shipment);
  }
}
