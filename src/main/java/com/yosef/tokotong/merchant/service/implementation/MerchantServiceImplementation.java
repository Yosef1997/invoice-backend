package com.yosef.tokotong.merchant.service.implementation;

import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import com.yosef.tokotong.exceptions.notFoundException.NotFoundException;
import com.yosef.tokotong.merchant.entity.Merchant;
import com.yosef.tokotong.merchant.repository.MerchantRepository;
import com.yosef.tokotong.merchant.service.MerchantService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class MerchantServiceImplementation implements MerchantService {
  private final MerchantRepository merchantRepository;

  public MerchantServiceImplementation (MerchantRepository merchantRepository) {
    this.merchantRepository = merchantRepository;
  }


  @Override
  public List<Merchant> getMerchants() {
    var result = merchantRepository.findAll();

    if (result.isEmpty()) {
      throw new NotFoundException("Merchants is empty");
    }

    return result;
  }

  @Override
  public Merchant createMerchant(Merchant merchant) {
    var result = merchantRepository.findByName(merchant.getName());
    if (result != null) {
      throw new ApplicationException("Merchant name already exists");
    }

    return merchantRepository.save(merchant);
  }
}
