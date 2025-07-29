package com.github.romanqed.jiter.primitive;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import static org.junit.jupiter.api.Assertions.*;

public final class PrimitiveIteratorTest {

    @Test
    public void testIntIteratorFull() {
        int[] array = {1, 2, 3, 4};
        var it = PrimitiveIterators.of(array);
        for (int expected : array) {
            assertTrue(it.hasNext());
            assertEquals(expected, it.nextInt());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::nextInt);
    }

    @Test
    public void testIntIteratorRange() {
        int[] array = {1, 2, 3, 4, 5};
        var it = PrimitiveIterators.of(array, 1, 4);
        for (int i = 1; i < 4; i++) {
            assertTrue(it.hasNext());
            assertEquals(array[i], it.nextInt());
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void testLongIteratorStart() {
        long[] array = {10L, 20L, 30L, 40L};
        var it = PrimitiveIterators.of(array, 2);
        assertEquals(30L, it.nextLong());
        assertEquals(40L, it.nextLong());
        assertFalse(it.hasNext());
    }

    @Test
    public void testDoubleIteratorEmpty() {
        double[] array = {};
        var it = PrimitiveIterators.of(array);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::nextDouble);
    }

    @Test
    public void testNullArray() {
        assertThrows(NullPointerException.class, () -> PrimitiveIterators.of((int[]) null));
        assertThrows(NullPointerException.class, () -> PrimitiveIterators.of((long[]) null, 0));
        assertThrows(NullPointerException.class, () -> PrimitiveIterators.of((double[]) null, 0, 0));
    }

    @Test
    public void testInvalidBounds() {
        int[] array = {1, 2, 3};
        assertThrows(IndexOutOfBoundsException.class, () -> PrimitiveIterators.of(array, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> PrimitiveIterators.of(array, 1, 5));
    }

    @Test
    public void testRemoveUnsupported() {
        int[] array = {1, 2};
        var it = PrimitiveIterators.of(array);
        assertThrows(UnsupportedOperationException.class, it::remove);
    }

    @Test
    public void testForEachRemaining_Int() {
        int[] array = {5, 6, 7, 8};
        var it = PrimitiveIterators.of(array, 1, 3);

        var sum = new AtomicInteger(0);
        it.forEachRemaining((IntConsumer) sum::addAndGet);
        assertEquals(6 + 7, sum.get());
        assertFalse(it.hasNext());
    }

    @Test
    public void testForEachRemaining_Long() {
        long[] array = {10L, 20L, 30L, 40L};
        PrimitiveIterator.OfLong it = PrimitiveIterators.of(array, 1, 4);

        var sum = new AtomicLong(0);
        it.forEachRemaining((LongConsumer) sum::addAndGet);
        assertEquals(20L + 30L + 40L, sum.get());
        assertFalse(it.hasNext());
    }

    @Test
    public void testForEachRemaining_Double() {
        double[] array = {1.5, 2.5, 3.5};
        var it = PrimitiveIterators.of(array);

        var sum = new AtomicReference<>(0.0);
        it.forEachRemaining((DoubleConsumer) d -> sum.set(sum.get() + d));
        assertEquals(7.5, sum.get());
        assertFalse(it.hasNext());
    }

    @Test
    public void testNextBoxedMethods() {
        int[] intArray = {1};
        var itInt = PrimitiveIterators.of(intArray);
        assertEquals(Integer.valueOf(1), itInt.next());

        long[] longArray = {2L};
        var itLong = PrimitiveIterators.of(longArray);
        assertEquals(Long.valueOf(2L), itLong.next());

        double[] doubleArray = {3.14};
        var itDouble = PrimitiveIterators.of(doubleArray);
        assertEquals(Double.valueOf(3.14), itDouble.next());
    }
}
