package com.assignment.netcalculator.service;

import java.math.BigDecimal;

public interface PriceCalculatorService {
    BigDecimal calculateNetPrice(BigDecimal grossPrice, String countryIso);
}
