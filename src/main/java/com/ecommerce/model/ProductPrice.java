package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_prices")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal basePrice;

    @Column(precision = 12, scale = 2)
    private BigDecimal salePrice;

    @Column(precision = 12, scale = 2)
    private BigDecimal costPrice;

    @Column(length = 3, nullable = false)
    private String currency = "KRW";;

    @Column(precision = 5, scale = 2)
    private BigDecimal taxRate;
}
