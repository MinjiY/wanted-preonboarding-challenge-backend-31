package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "product_tags",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "tag_id"})
)
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
