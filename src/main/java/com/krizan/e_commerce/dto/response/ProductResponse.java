package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.utils.Gender;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class ProductResponse {

    private final Long productId;
    private final Long vendorId;
    private final Gender gender;
    private final Long categoryId;
    private final String name;
    private final String description;
    private final String color;
    private final String size;
    private final BigDecimal unitPrice;
    private final Integer discount;
    private final BigDecimal finalUnitPrice;
    private final Integer quantity;

    public ProductResponse(Product product) {
        this.productId = product.getProductId();
        this.vendorId = product.getVendor().getVendorId();
        this.gender = product.getGender();
        this.categoryId = product.getCategory().getCategoryId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.color = product.getColor();
        this.size = product.getSize();
        this.unitPrice = product.getUnitPrice();
        this.discount = product.getDiscount();
        this.finalUnitPrice = calcFinalUnitPrice();
        this.quantity = product.getQuantity();
    }

    private BigDecimal calcFinalUnitPrice() {
        if (discount != null) {
            BigDecimal discountInBigDecimal = BigDecimal.valueOf(discount)
                    .divide(BigDecimal.valueOf(100), RoundingMode.UNNECESSARY);
            return unitPrice.subtract(unitPrice.multiply(discountInBigDecimal));
        } else return null;
    }
}