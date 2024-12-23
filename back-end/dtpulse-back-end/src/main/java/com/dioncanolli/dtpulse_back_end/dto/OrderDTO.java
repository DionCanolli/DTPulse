package com.dioncanolli.dtpulse_back_end.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
    private double amount;
    private String email;
}
