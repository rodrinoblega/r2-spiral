package com.r2.spiral.adapters.output;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.List;

@Getter
@EqualsAndHashCode
public class SpiralResponse {

    private final List<Integer> fibonacciResponse;

    public SpiralResponse(List<Integer> fibonacciResponse) {
        this.fibonacciResponse = fibonacciResponse;
    }
}
