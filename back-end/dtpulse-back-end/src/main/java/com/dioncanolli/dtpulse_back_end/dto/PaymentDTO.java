package com.dioncanolli.dtpulse_back_end.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDTO {
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
    private double amount;
}
