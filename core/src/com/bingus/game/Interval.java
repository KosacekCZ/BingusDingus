package com.bingus.game;

public class Interval {
    public static Interval instance;
    public static Interval getInstance() {
        if (instance == null) instance = new Interval();

        return instance;
    }

    public static float randInInterval(float start, float end) {
        return (float) Math.random() * (end - start) + start;
    }

    public static float randInInterval(float start, float i1, float i2, float end) {
        float interval1 = (float) Math.random() * (i1 - start) + start;
        float interval2 = (float) Math.random() * (end - i2) + i2;
        return (Math.random() <= 0.5 ? interval1 : interval2);
    }


}
