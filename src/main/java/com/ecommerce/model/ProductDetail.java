package com.ecommerce.model;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;
import org.hibernate.annotations.Type;
import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name = "product_details")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(precision = 10, scale = 2)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal weight;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> dimensions;

    @Column(columnDefinition = "text")
    private String materials;

    @Column(length = 100)
    private String countryOfOrigin;

    @Column(columnDefinition = "text")
    private String warrantyInfo;

    @Column(columnDefinition = "text")
    private String careInstructions;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> additionalInfo;
}
