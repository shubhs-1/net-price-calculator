package com.assignment.netcalculator.controller;


import com.assignment.netcalculator.exception.InvalidParameterPassedException;
import com.assignment.netcalculator.model.GrossPriceRequest;
import com.assignment.netcalculator.model.NetPriceResponse;
import com.assignment.netcalculator.rest.RestResponse;
import com.assignment.netcalculator.service.PriceCalculatorService;
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

@RunWith( MockitoJUnitRunner.class )
public class PriceControllerTest {

    @InjectMocks
    private PriceController priceController = Mockito.spy( new PriceController() );

    @Mock
    private PriceCalculatorService priceCalculatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test (expected = InvalidParameterPassedException.class)
    public void shouldThrowExceptionWhenParametersAreInvalid() throws Exception {
        GrossPriceRequest grossPriceRequest = GrossPriceRequest.builder().grossPrice(null).countryIso(null).build();
        priceController.getNetPrice(grossPriceRequest);
    }

    @Test
    public void shouldCorrectlyReturnAPIResponseWhenGivenRequestBodyIsValid() {
        GrossPriceRequest grossPriceRequest = GrossPriceRequest.builder().grossPrice(BigDecimal.valueOf(123.745)).countryIso("DE").build();
        Mockito.doReturn(BigDecimal.valueOf(84.1)).when(priceCalculatorService).calculateNetPrice(grossPriceRequest.getGrossPrice(), grossPriceRequest.getCountryIso());
        RestResponse response = priceController.getNetPrice(grossPriceRequest);

        Assert.assertEquals(response.getStatus(), "success");
        Assert.assertEquals(response.getData(), NetPriceResponse.builder().netPrice(BigDecimal.valueOf(84.1)).build());
    }
}
