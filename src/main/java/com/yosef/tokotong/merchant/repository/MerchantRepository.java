package com.yosef.tokotong.merchant.repository;

import com.yosef.tokotong.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
  Merchant findByName(String name);
}
