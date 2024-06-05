package com.yosef.tokotong.merchant.service;

import com.yosef.tokotong.merchant.entity.Merchant;

import java.util.List;

public interface MerchantService {

  public List<Merchant> getMerchants ();

  public Merchant createMerchant (Merchant merchant);
}
