package com.r2.spiral.adapters.request;

import com.r2.spiral.useCases.input.Request;

public class RequestParameterParser {

    public Request parse(String rows, String cols) {
        return new Request(rows, cols);
    }
}
