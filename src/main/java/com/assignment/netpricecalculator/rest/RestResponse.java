package com.assignment.netpricecalculator.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestResponse {
    private Object data;
    private String status;
    private String message;
}
