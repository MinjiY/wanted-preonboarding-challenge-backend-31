package com.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "product_categories",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "category_id"})
)
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private Boolean isPrimary = false;
}
