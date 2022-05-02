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

        int colsMinVertex = 0;
        int colsMaxVertex = request.getCols() - 1;
        int rowsMinVertex = 0;
        int rowsMaxVertex = request.getRows() - 1;


        int [][] rows = new int [request.getRows()] [request.getCols()];

        while((colsMinVertex != colsMaxVertex || rowsMinVertex != rowsMaxVertex) && fibonacci.size() != 0) {
            completeBorders(fibonacci, rows, colsMinVertex, colsMaxVertex, rowsMinVertex, rowsMaxVertex);

            colsMinVertex = colsMinVertex + 1;
            rowsMinVertex = rowsMinVertex + 1;
            colsMaxVertex = colsMaxVertex - 1;
            rowsMaxVertex = rowsMaxVertex - 1;
        }

        if (fibonacci.size() != 0) {
            rows[colsMinVertex][rowsMinVertex] = fibonacci.get(0);
        }


        return new SpiralResponse(fibonacciGeneratorResponse.getTimestamp(), rows);
    }

    private void completeBorders(List<Integer> fibonacci, int[][] rows, int colsMinVertex, int colsMaxVertex, int rowsMinVertex, int rowsMaxVertex) {
        for (int i = colsMinVertex; i <= colsMaxVertex; i++) {
            rows[rowsMinVertex][i] = fibonacci.get(0);
            fibonacci.remove(0);
        }

        for (int i = rowsMinVertex + 1; i <= rowsMaxVertex; i++) {
            rows[i][colsMaxVertex] = fibonacci.get(0);
            fibonacci.remove(0);
        }

        if (fibonacci.size() != 0) {
            for (int i = colsMaxVertex - 1; i >= colsMinVertex; i--) {
                rows[rowsMaxVertex][i] = fibonacci.get(0);
                fibonacci.remove(0);
            }

            for (int i = rowsMaxVertex - 1; i >= colsMinVertex + 1; i--) {
                rows[i][colsMinVertex] = fibonacci.get(0);
                fibonacci.remove(0);
            }
        }
    }
}
