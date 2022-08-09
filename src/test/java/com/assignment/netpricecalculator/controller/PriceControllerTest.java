package com.assignment.netpricecalculator.controller;


import com.assignment.netpricecalculator.exception.InvalidParameterPassedException;
import com.assignment.netpricecalculator.model.ConsumerRequest;
import com.assignment.netpricecalculator.model.ConsumerResponse;
import com.assignment.netpricecalculator.rest.RestResponse;
import com.assignment.netpricecalculator.service.NetPriceCalculatorService;
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
    private NetPriceCalculatorService netPriceCalculatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test (expected = InvalidParameterPassedException.class)
    public void shouldThrowExceptionWhenParametersAreInvalid() throws Exception {
        ConsumerRequest consumerRequest = ConsumerRequest.builder().grossPrice(null).countryIso(null).build();
        priceController.getNetPrice(consumerRequest);
    }

    @Test
    public void shouldCorrectlyReturnAPIResponseWhenGivenRequestBodyIsValid() {
        ConsumerRequest consumerRequest = ConsumerRequest.builder().grossPrice(BigDecimal.valueOf(123.745)).countryIso("DE").build();
        Mockito.doReturn(BigDecimal.valueOf(84.1)).when(netPriceCalculatorService).calculateNetPrice(consumerRequest.getGrossPrice(), consumerRequest.getCountryIso());
        RestResponse response = priceController.getNetPrice(consumerRequest);

        Assert.assertEquals(response.getStatus(), "success");
        Assert.assertEquals(response.getData(), ConsumerResponse.builder().netPrice(BigDecimal.valueOf(84.1)).build());
    }
}
