package com.r2.spiral.useCases;

import com.r2.spiral.useCases.input.Request;
import com.r2.spiral.useCases.output.FibonacciGeneratorResponse;

import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator {

    public FibonacciGeneratorResponse execute(Request request) {
        List<Integer> fibonacci = new ArrayList<>();
        int cantNums = obtainCantNums(request);
        int last = 1;
        int beforeLast = 0;

        fibonacci.add(beforeLast);
        fibonacci.add(last);

        for(int i = 3; i <= cantNums; i ++) {
            int valueUpdated = last + beforeLast;
            beforeLast = last;
            last = valueUpdated;
            fibonacci.add(valueUpdated);
        }

        return new FibonacciGeneratorResponse(fibonacci);
    }

    private int obtainCantNums(Request request) {
        return request.getCols() * request.getRows();
    }
}
