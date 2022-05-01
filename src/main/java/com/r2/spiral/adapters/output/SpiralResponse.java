package com.r2.spiral.adapters.output;

import java.util.List;
import java.util.Objects;

public class SpiralResponse {

    private final List<Integer> fibonacciResponse;

    public SpiralResponse(List<Integer> fibonacciResponse) {
        this.fibonacciResponse = fibonacciResponse;
    }

    public List<Integer> getFibonacciResponse() {
        return fibonacciResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpiralResponse that = (SpiralResponse) o;
        return Objects.equals(fibonacciResponse, that.fibonacciResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fibonacciResponse);
    }
}
