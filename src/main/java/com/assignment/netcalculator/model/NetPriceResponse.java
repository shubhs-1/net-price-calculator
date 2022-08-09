package com.assignment.netcalculator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class NetPriceResponse {
    private BigDecimal netPrice;
}
