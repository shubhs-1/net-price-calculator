package com.assignment.netcalculator.controller;

import com.assignment.netcalculator.exception.InvalidParameterPassedException;
import com.assignment.netcalculator.model.GrossPriceRequest;
import com.assignment.netcalculator.model.NetPriceResponse;
import com.assignment.netcalculator.rest.RestResponse;
import com.assignment.netcalculator.service.PriceCalculatorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Log4j2
@RestController
@RequestMapping(value = "/api/v1/calculate")
public class PriceController {

    @Autowired
    PriceCalculatorService priceCalculatorService;

    @PostMapping("/netprice")
    public RestResponse getNetPrice(@RequestBody GrossPriceRequest grossPriceRequest) {
        if(ObjectUtils.isEmpty(grossPriceRequest.getGrossPrice()) || ObjectUtils.isEmpty(grossPriceRequest.getCountryIso())) {
            log.error("Exception occurred while validating request");
            throw new InvalidParameterPassedException();
        }
        BigDecimal netPrice = priceCalculatorService.calculateNetPrice(grossPriceRequest.getGrossPrice(), grossPriceRequest.getCountryIso());
        NetPriceResponse netPriceResponse = NetPriceResponse.builder().netPrice(netPrice).build();
        return RestResponse.builder().data(netPriceResponse).status("success").build();
    }
}
