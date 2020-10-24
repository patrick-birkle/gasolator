package de.itbirkle.gasolator.utils;

import org.apache.commons.lang3.StringUtils;

public class Reject {

    public static <T> void  ifNull(T t, String objectName) {
        if (t == null) {
            throw new IllegalArgumentException(objectName + " should not be null");
        }
    }

    public static void ifBlank(String string, String attributeName) {
        ifNull(string, attributeName);
        if (StringUtils.isBlank(string)) {
            throw new IllegalArgumentException(attributeName + " should not be blank");
        }
    }
}