package com.assignment.netcalculator.service;

import java.math.BigDecimal;
import java.util.Map;

public interface TaxRateService {
    Map<String, BigDecimal> getTaxRateByCountry();
}
