package com.assignment.netcalculator.service.impl;

import com.assignment.netcalculator.exception.DataNotFoundException;
import com.assignment.netcalculator.service.PriceCalculatorService;
import com.assignment.netcalculator.service.TaxRateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Log4j2
@Service
public class PriceCalculatorServiceImpl implements PriceCalculatorService {

    @Autowired
    TaxRateService taxRateService;

    @Override
    public BigDecimal calculateNetPrice(BigDecimal grossPrice, String countryIso) {
        try {
            BigDecimal rate = taxRateService.getTaxRateByCountry().get(countryIso);
            BigDecimal netPrice = grossPrice.subtract(grossPrice.multiply(rate));
            netPrice = netPrice.setScale(1, BigDecimal.ROUND_HALF_EVEN);
            log.info("Calculated NetPrice: {} for CountryIso: {}", netPrice, countryIso);
            return netPrice;
        } catch (Exception exception) {
            log.error("Exception occurred while calculating net price, exception: {}", exception);
            throw new DataNotFoundException();
        }
    }
}
