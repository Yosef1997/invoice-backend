package com.yosef.tokotong.shipments.repository;

import com.yosef.tokotong.shipments.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentsRepository extends JpaRepository<Shipment, Long> {
  List<Shipment> findByName(String name);
}
