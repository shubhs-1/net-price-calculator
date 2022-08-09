package com.assignment.netpricecalculator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ConsumerResponse {
    private BigDecimal netPrice;
}
