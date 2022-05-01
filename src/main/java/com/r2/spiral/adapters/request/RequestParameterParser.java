package com.r2.spiral.adapters.request;

import com.r2.spiral.adapters.request.validations.RequestValidationException;
import com.r2.spiral.useCases.input.Request;

public class RequestParameterParser {

    public Request parse(String rows, String cols) {

        try {
            int rowsInt = Integer.parseInt(rows);
            int colsInt = Integer.parseInt(cols);

            return new Request(rowsInt, colsInt);
        } catch (Exception e) {
            throw new RequestValidationException("Query params must be numeric");
        }
    }
}
