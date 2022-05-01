package com.r2.spiral.adapters.presenters;

import com.r2.spiral.adapters.output.SpiralResponse;
import com.r2.spiral.useCases.output.FibonacciGeneratorResponse;

public interface Presenter {
    SpiralResponse present(FibonacciGeneratorResponse fibonacciGeneratorResponse);
}
