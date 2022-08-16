package com.assignment.netpricecalculator.service;

import java.math.BigDecimal;

/**
 * Interface to provide services related to NetPrice calculation
 * @author Shubham Kalaria
 */
public interface NetPriceCalculatorService {
    /**
     * Method to calculate net price given grossPrice and countryIso
     * @param grossPrice gross price of standard taxable goods
     * @param countryIso country iso
     * @return net price
     */
    BigDecimal calculateNetPrice(BigDecimal grossPrice, String countryIso);
}
