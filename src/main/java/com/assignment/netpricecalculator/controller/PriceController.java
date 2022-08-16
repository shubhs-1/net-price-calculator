package com.assignment.netpricecalculator.controller;

import com.assignment.netpricecalculator.exception.InvalidParameterPassedException;
import com.assignment.netpricecalculator.model.ConsumerRequest;
import com.assignment.netpricecalculator.model.ConsumerResponse;
import com.assignment.netpricecalculator.rest.RestResponse;
import com.assignment.netpricecalculator.service.NetPriceCalculatorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Rest Controller to expose REST API endpoints related to net price calculation
 * @author Shubham Kalaria
 */
@Log4j2
@RestController
@RequestMapping(value = "/api/v1/calculate")
public class PriceController {

    @Autowired
    NetPriceCalculatorService netPriceCalculatorService;

    /**
     * API Endpoint to provide net price given gross price and country iso
     * @param consumerRequest
     * @return
     */
    @PostMapping("/netprice")
    public RestResponse getNetPrice(@RequestBody ConsumerRequest consumerRequest) {
        if(ObjectUtils.isEmpty(consumerRequest.getGrossPrice()) || ObjectUtils.isEmpty(consumerRequest.getCountryIso())) {
            log.error("Exception occurred while validating request");
            throw new InvalidParameterPassedException();
        }
        BigDecimal netPrice = netPriceCalculatorService.calculateNetPrice(consumerRequest.getGrossPrice(), consumerRequest.getCountryIso());
        ConsumerResponse consumerResponse = ConsumerResponse.builder().netPrice(netPrice).build();
        return RestResponse.builder().data(consumerResponse).status("success").build();
    }
}
