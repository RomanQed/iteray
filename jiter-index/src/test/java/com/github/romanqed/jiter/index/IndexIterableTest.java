package com.github.romanqed.jiter.index;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public final class IndexIterableTest {

    @Test
    public void testIntArrayFull() {
        int[] array = {1, 2, 3, 4};
        var iterable = IndexIterables.of(array);
        var it = iterable.iterator();
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
        var iterable = IndexIterables.of(array, 1, 4);
        var it = iterable.iterator();
        for (var i = 1; i < 4; ++i) {
            assertTrue(it.hasNext());
            assertEquals(array[i], it.next());
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void testLongArrayStart() {
        long[] array = {10L, 20L, 30L, 40L};
        var iterable = IndexIterables.of(array, 2);
        var it = iterable.iterator();
        assertEquals(30L, it.next());
        assertEquals(40L, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testDoubleArrayEmpty() {
        double[] array = {};
        var iterable = IndexIterables.of(array);
        var it = iterable.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void testNullArray() {
        assertThrows(NullPointerException.class, () -> IndexIterables.of((int[]) null));
        assertThrows(NullPointerException.class, () -> IndexIterables.of((long[]) null, 0));
        assertThrows(NullPointerException.class, () -> IndexIterables.of((double[]) null, 0, 0));
    }

    @Test
    public void testInvalidBounds() {
        int[] array = {1, 2, 3};
        assertThrows(IndexOutOfBoundsException.class, () -> IndexIterables.of(array, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> IndexIterables.of(array, 1, 5));
    }

    @Test
    public void testGenericIndexable() {
        var indexable = new ArrayIndexable<>(new String[]{"a", "b", "c"});
        var iterable = IndexIterables.of(indexable, 3);
        var it = iterable.iterator();
        assertEquals("a", it.next());
        assertEquals("b", it.next());
        assertEquals("c", it.next());
        assertFalse(it.hasNext());
    }
}
