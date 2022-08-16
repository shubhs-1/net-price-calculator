package com.assignment.netpricecalculator.service.impl;

import com.assignment.netpricecalculator.service.TaxRateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implementing the TaxRate interface
 * @author Shubham Kalaria
 */
@Service
public class TaxRateServiceImpl implements TaxRateService {

    /**
     * Method to get tax rate for all the countries
     * @return taxRate to courtryIso mapping
     */
    @Override
    public Map<String, BigDecimal> getTaxRateByCountry() {
        Map<String, BigDecimal> taxRateMap = new HashMap<>();
        taxRateMap.put("DE", new BigDecimal(0.19));
        taxRateMap.put("FR", new BigDecimal(0.20));
        taxRateMap.put("BE", new BigDecimal(0.21));
        taxRateMap.put("CY", new BigDecimal(0.19));
        taxRateMap.put("DK", new BigDecimal(0.25));
        taxRateMap.put("FI", new BigDecimal(0.24));
        taxRateMap.put("LU", new BigDecimal(0.17));
        taxRateMap.put("HU", new BigDecimal(0.27));

        return taxRateMap;
    }
}
