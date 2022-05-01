package com.r2.spiral.useCases.input;

public class Request {
    private final int rows;
    private final int cols;

    public Request(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
