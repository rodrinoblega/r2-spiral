package com.r2.spiral.adapters.request;

import com.r2.spiral.adapters.request.validations.RequestValidationException;
import com.r2.spiral.useCases.input.Request;

public class RequestParameterParser {

    public Request parse(String rows, String cols) {
        int rowsInt = 0;
        int colsInt = 0;

        try {
            rowsInt = Integer.parseInt(rows);
            colsInt = Integer.parseInt(cols);
        } catch (Exception e) {
            throw new RequestValidationException("Query params must be numeric");
        }

        if (rowsInt <=0 || colsInt <=0) {
            throw new RequestValidationException("Cols and rows must be > 0");
        }

        return new Request(rowsInt, colsInt);
    }
}
