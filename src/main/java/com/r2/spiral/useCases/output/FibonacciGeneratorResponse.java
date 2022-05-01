package com.r2.spiral.useCases.output;

import java.util.List;

public class FibonacciGeneratorResponse {
    private List<Integer> fibonacciResponse;

    public FibonacciGeneratorResponse(List<Integer> fibonacciResponse) {
        this.fibonacciResponse = fibonacciResponse;
    }

    public List<Integer> getFibonacciResponse() {
        return fibonacciResponse;
    }
}
