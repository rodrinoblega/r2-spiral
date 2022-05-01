package com.r2.spiral.frameworks.presenters;

import com.r2.spiral.adapters.output.SpiralResponse;
import com.r2.spiral.adapters.presenters.Presenter;
import com.r2.spiral.useCases.output.FibonacciGeneratorResponse;

public class SpiralPresenter implements Presenter {
    @Override
    public SpiralResponse present(FibonacciGeneratorResponse fibonacciGeneratorResponse) {
        return new SpiralResponse(fibonacciGeneratorResponse.getFibonacciResponse());
    }
}
