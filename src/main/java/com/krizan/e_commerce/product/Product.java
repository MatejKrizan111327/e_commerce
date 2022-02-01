package com.krizan.e_commerce.product;

import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long id;

    @NonNull
    private Long vendorId;

    @NonNull
    private Long categoryId;

    @NonNull
    private String name;

    @Nullable
    private String description;

    @NonNull
    private String color;

    @NonNull
    private String size;

    @NonNull
    private Double unitPrice;

    @NonNull
    private Boolean discountAvailable;

    @NonNull
    private Integer discount;

    @Nullable
    private Double finalUnitPrice;

    @NonNull
    private Boolean onOrder;

    public Double calcFinalUnitPrice() {
        Double discountInDecimal = Double.valueOf(discount) / 100;
        return unitPrice - unitPrice * discountInDecimal;
    }
}
