package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "sellers")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private String logoUrl;
    private BigDecimal rating;

    private String contactEmail;
    private String contactPhone;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();
}
