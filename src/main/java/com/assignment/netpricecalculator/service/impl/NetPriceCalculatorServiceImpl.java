package com.assignment.netpricecalculator.service.impl;

import com.assignment.netpricecalculator.exception.DataNotFoundException;
import com.assignment.netpricecalculator.service.NetPriceCalculatorService;
import com.assignment.netpricecalculator.service.TaxRateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Log4j2
@Service
public class NetPriceCalculatorServiceImpl implements NetPriceCalculatorService {

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
