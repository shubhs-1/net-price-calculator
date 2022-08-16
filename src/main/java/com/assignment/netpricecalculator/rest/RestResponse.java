package com.assignment.netpricecalculator.rest;

import lombok.Builder;
import lombok.Data;

/**
 * POJO class to represent rest response
 * @author Shubham Kalaria
 */
@Data
@Builder
public class RestResponse {
    private Object data;
    private String status;
    private String message;
}
