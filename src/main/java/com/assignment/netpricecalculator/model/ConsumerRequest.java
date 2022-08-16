package com.assignment.netpricecalculator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * POJO class to represent consumer request
 * @author Shubham Kalaria
 */
@Data
@Builder
public class ConsumerRequest {
    private BigDecimal grossPrice;
    private String countryIso;
}
