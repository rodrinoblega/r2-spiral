package com.r2.spiral.frameworks.presenters;

import com.r2.spiral.adapters.output.SpiralResponse;
import com.r2.spiral.adapters.presenters.Presenter;
import com.r2.spiral.useCases.input.Request;
import com.r2.spiral.useCases.output.FibonacciGeneratorResponse;

import java.util.List;

public class SpiralPresenter implements Presenter {
    @Override
    public SpiralResponse present(FibonacciGeneratorResponse fibonacciGeneratorResponse, Request request) {
        List<Integer> fibonacci = fibonacciGeneratorResponse.getFibonacciResponse();

        int lowLimitX = 0;
        int lowLimitY = 0;
        int highLimitY = request.getRows() - 1;
        int highLimitX = request.getCols() - 1;


        int [][] rows = new int [request.getRows()] [request.getCols()];

        while((lowLimitX != highLimitX || lowLimitY != highLimitY) && fibonacci.size() != 0) {
            for (int i = lowLimitX; i <= highLimitX; i++) {
                rows[lowLimitY][i] = fibonacci.get(0);
                fibonacci.remove(0);
            }

            for (int i = lowLimitY + 1; i <= highLimitY; i++) {
                rows[i][highLimitX] = fibonacci.get(0);
                fibonacci.remove(0);
            }

            if (fibonacci.size() != 0) {
                for (int i = highLimitX - 1; i >= lowLimitX; i--) {
                    rows[highLimitY][i] = fibonacci.get(0);
                    fibonacci.remove(0);
                }

                for (int i = highLimitY - 1; i >= lowLimitX + 1; i--) {
                    rows[i][lowLimitX] = fibonacci.get(0);
                    fibonacci.remove(0);
                }
            }

            lowLimitX = lowLimitX + 1;
            lowLimitY = lowLimitY + 1;
            highLimitX = highLimitX - 1;
            highLimitY = highLimitY - 1;
        }

        if (fibonacci.size() != 0) {
            rows[lowLimitX][lowLimitY] = fibonacci.get(0);
        }


        return new SpiralResponse(fibonacciGeneratorResponse.getTimestamp(), rows);
    }
}
