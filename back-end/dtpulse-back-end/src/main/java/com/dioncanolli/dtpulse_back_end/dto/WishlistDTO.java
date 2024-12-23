package com.dioncanolli.dtpulse_back_end.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WishlistDTO {
    private String username;
    private String email;
    private String productName;
    private String productCategory;
    private double productPrice;

    public WishlistDTO(String username, String email, String productName, String productCategory, double productPrice) {
        this.username = username;
        this.email = email;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public WishlistDTO(String productName, String productCategory, double productPrice) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public WishlistDTO(String productName) {
        this.productName = productName;
    }

    public WishlistDTO() {
    }
}
