package de.itbirkle.gasolator.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RejectTest {

    @Test
    void ifNull() {
        assertThrows(IllegalArgumentException.class, () -> Reject.ifNull(null, "test"));
    }

    @Test
    void ifBlank() {
        assertThrows(IllegalArgumentException.class, () -> Reject.ifBlank(null, "test"));
        assertThrows(IllegalArgumentException.class, () -> Reject.ifBlank("", "test"));
        assertThrows(IllegalArgumentException.class, () -> Reject.ifBlank("   ", "test"));
    }

    @Test
    void ifLessOrEqualZero() {
        assertThrows(IllegalArgumentException.class, () -> Reject.ifLessOrEqualZero(0, "test"));
        assertThrows(IllegalArgumentException.class, () -> Reject.ifLessOrEqualZero(-1, "test"));
    }

    @Test
    void testIfLessOrEqualZero() {
        assertThrows(IllegalArgumentException.class, () -> Reject.ifLessOrEqualZero(0.0, "test"));
        assertThrows(IllegalArgumentException.class, () -> Reject.ifLessOrEqualZero(-1.0, "test"));
    }
}