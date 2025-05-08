package com.ecommerce.model;

import com.ecommerce.ProductStatus;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String slug;

    @Column(length = 500)
    private String shortDescription;

    @Column(columnDefinition = "text")
    private String fullDescription;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @OneToOne(mappedBy = "product", orphanRemoval = true)
    private ProductDetail detail;

    @OneToOne(mappedBy = "product", orphanRemoval = true)
    private ProductPrice price;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductCategory> categories = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductOptionGroup> optionGroups = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();
}
