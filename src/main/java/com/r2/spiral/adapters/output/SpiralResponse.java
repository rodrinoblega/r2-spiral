package com.r2.spiral.adapters.output;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class SpiralResponse {

    private final String ts;
    private final int[][] rows;

    public SpiralResponse(String ts, int[][] rows) {
        this.ts = ts;
        this.rows = rows;
    }
}
