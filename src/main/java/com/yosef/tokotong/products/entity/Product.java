package com.yosef.tokotong.products.entity;

import com.yosef.tokotong.merchant.entity.Merchant;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required")
  private String name;

  @DecimalMin(value = "0.0", message = "Price must be non-negative")
  private BigDecimal price;

  @DecimalMin(value = "0.0", message = "Weight must be non-negative")
  private BigDecimal weight;

  @ManyToOne
  @JoinColumn(name = "merchant_Id", nullable = false)
  private Merchant merchant;

  @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createdAt;

  @Column(nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime  updatedAt;
}
