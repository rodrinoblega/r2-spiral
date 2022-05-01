package com.r2.spiral.configuration;

import com.r2.spiral.adapters.SpiralController;
import com.r2.spiral.adapters.presenters.Presenter;
import com.r2.spiral.adapters.request.RequestParameterParser;
import com.r2.spiral.frameworks.presenters.SpiralPresenter;
import com.r2.spiral.useCases.FibonacciGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FibonacciGenerator spiralGenerator() {
        return new FibonacciGenerator();
    }

    @Bean
    Presenter presenter() { return new SpiralPresenter(); }

    @Bean
    RequestParameterParser requestParameterParser() { return new RequestParameterParser(); }

}
