package de.itbirkle.gasolator.utils;

import org.apache.commons.lang3.StringUtils;

public class Reject {

    public static <T> void  ifNull(T t, String message) {
        if (t == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void ifBlank(String string, String message) {
        if (StringUtils.isBlank(string)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void ifLessOrEqualZero(long value, String message) {
        if (value <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void ifLessOrEqualZero(double value, String message) {
        if (value <= 0.0) {
            throw new IllegalArgumentException(message);
        }
    }
}
