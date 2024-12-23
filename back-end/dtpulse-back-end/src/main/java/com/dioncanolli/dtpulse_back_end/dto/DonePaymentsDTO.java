package com.dioncanolli.dtpulse_back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class DonePaymentsDTO {
    private double amount;
    private Timestamp paymentDate;
}
