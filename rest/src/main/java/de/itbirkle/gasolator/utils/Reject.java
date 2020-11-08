package de.itbirkle.gasolator.utils;

public class Reject {

    public static <T> void ifNull(T t, String message) {
        if (t == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void ifBlank(String string, String message) {
        ifNull(string, message);
        if (string.isBlank()) {
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
