package com.r2.spiral.useCases.output;

import java.util.List;

public class FibonacciGeneratorResponse {
    private String timestamp;
    private List<Integer> fibonacciResponse;

    public FibonacciGeneratorResponse(String timestamp, List<Integer> fibonacciResponse) {
        this.timestamp = timestamp;
        this.fibonacciResponse = fibonacciResponse;
    }

    public List<Integer> getFibonacciResponse() {
        return fibonacciResponse;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
