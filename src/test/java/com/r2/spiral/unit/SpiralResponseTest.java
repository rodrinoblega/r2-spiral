package com.r2.spiral.unit;

import com.r2.spiral.adapters.output.SpiralResponse;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class SpiralResponseTest {

    @Test
    public void simpleEqualsContract() {
        EqualsVerifier.simple().forClass(SpiralResponse.class).verify();
    }
}
