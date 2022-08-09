package com.assignment.netcalculator.service;

import com.assignment.netcalculator.service.impl.TaxRateServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class TaxRateCalculatorTest {
    @InjectMocks
    private TaxRateService taxRateService = Mockito.spy(new TaxRateServiceImpl());


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void shouldCorrectlyCreateMapOfTaxRateByCountryIso() {
        Map<String, BigDecimal> map = taxRateService.getTaxRateByCountry();

        Assert.assertEquals(map.get("DE"), new BigDecimal(0.19));
        Assert.assertEquals(map.get("BE"), new BigDecimal(0.21));
        Assert.assertEquals(map.get("HU"), new BigDecimal(0.27));
    }
}