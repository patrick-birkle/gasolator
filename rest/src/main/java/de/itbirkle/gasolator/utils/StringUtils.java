package de.itbirkle.gasolator.utils;

public class StringUtils {

    private static boolean isNull(String string) {
        return string == null;
    }

    private static boolean isNotNull(String string) {
        return !isNull(string);
    }

    public static boolean isEmpty(String string) {
        return isNull(string) || string.isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return isNotNull(string) && !isEmpty(string);
    }

    public static boolean isBlank(String string) {
        return isNull(string) || isEmpty(string) || string.isBlank();
    }

    public static boolean isNotBlank(String string) {
        return isNotNull(string) && isNotEmpty(string) && !isBlank(string);
    }

}
