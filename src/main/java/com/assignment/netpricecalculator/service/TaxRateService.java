package com.assignment.netpricecalculator.service;

import java.math.BigDecimal;
import java.util.Map;

public interface TaxRateService {
    Map<String, BigDecimal> getTaxRateByCountry();
}
