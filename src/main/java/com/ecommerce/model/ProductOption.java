package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "product_options")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(precision = 10, scale = 2)
    private BigDecimal additionalPrice = BigDecimal.ZERO;

    @Column(length = 100)
    private String sku;

    private Integer stock=0;

    private Integer displayOrder=0;

    @OneToMany(mappedBy = "option", orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();
}
