package com.assignment.netpricecalculator.service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Interface to provide TaxRate related services
 * @author Shubham Kalaria
 */
public interface TaxRateService {
    /**
     * Method to get tax rate for all the countries
     * @return taxRate to courtryIso mapping
     */
    Map<String, BigDecimal> getTaxRateByCountry();
}
