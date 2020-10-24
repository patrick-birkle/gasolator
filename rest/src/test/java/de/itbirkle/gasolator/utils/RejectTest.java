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
}