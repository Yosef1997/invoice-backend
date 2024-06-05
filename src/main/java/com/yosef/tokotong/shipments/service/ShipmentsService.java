package com.yosef.tokotong.shipments.service;

import com.yosef.tokotong.shipments.entity.Shipment;

import java.util.List;

public interface ShipmentsService {
  public List<Shipment> getShipments();

  public Shipment createShipment (Shipment shipment);
}
