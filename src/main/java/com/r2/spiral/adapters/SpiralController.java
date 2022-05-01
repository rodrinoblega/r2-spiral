package com.r2.spiral.adapters;

import com.r2.spiral.adapters.output.SpiralResponse;
import com.r2.spiral.adapters.presenters.Presenter;
import com.r2.spiral.adapters.request.RequestParameterParser;
import com.r2.spiral.useCases.FibonacciGenerator;
import com.r2.spiral.useCases.input.Request;
import com.r2.spiral.useCases.output.FibonacciGeneratorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpiralController {

    private final FibonacciGenerator fibonacciGenerator;
    private final Presenter presenter;
    private final RequestParameterParser requestParameterParser;

    public SpiralController(FibonacciGenerator fibonacciGenerator, Presenter presenter, RequestParameterParser requestParameterParser) {
        this.fibonacciGenerator = fibonacciGenerator;
        this.presenter = presenter;
        this.requestParameterParser = requestParameterParser;
    }

    @GetMapping("/spiral")
    public ResponseEntity<SpiralResponse> spiral(@RequestParam String rows, @RequestParam String cols) {
        Request request = requestParameterParser.parse(rows, cols);

        FibonacciGeneratorResponse fibonacciGeneratorResponse = fibonacciGenerator.execute(request);
        SpiralResponse spiralResponse = presenter.present(fibonacciGeneratorResponse);

        return ResponseEntity.status(200).body(spiralResponse);
    }
}
