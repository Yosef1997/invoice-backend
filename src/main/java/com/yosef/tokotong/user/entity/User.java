package com.yosef.tokotong.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Address is required")
  private String address;

  @NotBlank(message = "Phone is required")
  private String phone;

  @DecimalMin(value = "0.0", inclusive = false, message = "Credit must be greater than 0")
  @Digits(integer = 38, fraction = 2)
  private BigDecimal credit;

  @DecimalMin(value = "0.0", inclusive = true, message = "Coins must be non-negative")
  @Digits(integer = 38, fraction = 2)
  private BigDecimal coins;

  @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp createdAt;

  @Column(name = "updated_at", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp updatedAt;
}
