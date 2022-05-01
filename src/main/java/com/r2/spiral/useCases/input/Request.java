package com.r2.spiral.useCases.input;

public class Request {
    private final int rows;
    private final int cols;

    public Request(String rows, String cols) {
        this.rows = Integer.parseInt(rows);
        this.cols = Integer.parseInt(cols);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
