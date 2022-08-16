package com.assignment.netpricecalculator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * POJO class to represent consumer response
 * @author Shubham Kalaria
 */
@Data
@Builder
public class ConsumerResponse {
    private BigDecimal netPrice;
}
