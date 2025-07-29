package com.github.romanqed.jiter.index;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public final class IndexIteratorTest {

    @Test
    public void testIntArrayFull() {
        int[] array = {1, 2, 3, 4};
        var it = IndexIterators.of(array);
        for (var expected : array) {
            assertTrue(it.hasNext());
            assertEquals(expected, it.next());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void testIntArrayRange() {
        int[] array = {1, 2, 3, 4, 5};
        var it = IndexIterators.of(array, 1, 4);
        for (var i = 1; i < 4; ++i) {
            assertTrue(it.hasNext());
            assertEquals(array[i], it.next());
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void testLongArrayStart() {
        long[] array = {10L, 20L, 30L, 40L};
        var it = IndexIterators.of(array, 2);
        assertEquals(30L, it.next());
        assertEquals(40L, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testDoubleArrayEmpty() {
        double[] array = {};
        var it = IndexIterators.of(array);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void testNullArray() {
        assertThrows(NullPointerException.class, () -> IndexIterators.of((int[]) null));
        assertThrows(NullPointerException.class, () -> IndexIterators.of((long[]) null, 0));
        assertThrows(NullPointerException.class, () -> IndexIterators.of((double[]) null, 0, 0));
    }

    @Test
    public void testInvalidBounds() {
        int[] array = {1, 2, 3};
        assertThrows(IndexOutOfBoundsException.class, () -> IndexIterators.of(array, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> IndexIterators.of(array, 1, 5));
    }

    @Test
    public void testGenericIndexable() {
        var indexable = new ArrayIndexable<>(new String[]{"a", "b", "c"});
        var it = IndexIterators.of(indexable, 3);
        assertEquals("a", it.next());
        assertEquals("b", it.next());
        assertEquals("c", it.next());
        assertFalse(it.hasNext());
    }
}
