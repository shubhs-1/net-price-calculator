package com.assignment.netpricecalculator.service;


import com.assignment.netpricecalculator.exception.DataNotFoundException;
import com.assignment.netpricecalculator.service.impl.NetPriceCalculatorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class NetPriceCalculatorServiceTest {
    @InjectMocks
    private NetPriceCalculatorService netPriceCalculatorService = Mockito.spy( new NetPriceCalculatorServiceImpl() );

    @Mock
    private TaxRateService taxRateService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test(expected = DataNotFoundException.class)
    public void shouldThrowDataNotFoundExceptionWhenTaxRateForGivenCountryIsNotFound() {
        Mockito.doReturn(getTaxByCountryMap()).when(taxRateService).getTaxRateByCountry();
        netPriceCalculatorService.calculateNetPrice(BigDecimal.valueOf(123.51), "IN");
    }

    @Test
    public void shouldCorrectlyCalculateNetPriceIfTaxRateIsFoundForGivenCountry() {
        Mockito.doReturn(getTaxByCountryMap()).when(taxRateService).getTaxRateByCountry();
        BigDecimal netPrice1 = netPriceCalculatorService.calculateNetPrice(BigDecimal.valueOf(1.99), "FR");
        BigDecimal netPrice2 = netPriceCalculatorService.calculateNetPrice(BigDecimal.valueOf(100), "DE");

        Assert.assertEquals(netPrice1, BigDecimal.valueOf(1.6));
        Assert.assertEquals(netPrice2, BigDecimal.valueOf(81.0));
    }

    private Map<String, BigDecimal> getTaxByCountryMap() {
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
