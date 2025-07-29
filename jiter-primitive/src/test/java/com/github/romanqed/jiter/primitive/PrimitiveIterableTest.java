package com.github.romanqed.jiter.primitive;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import static org.junit.jupiter.api.Assertions.*;

public final class PrimitiveIterableTest {

    @Test
    public void testIntIterableFull() {
        int[] array = {1, 2, 3, 4};
        var iterable = PrimitiveIterables.of(array);
        var it = iterable.iterator();
        for (var expected : array) {
            assertTrue(it.hasNext());
            assertEquals(expected, it.nextInt());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::nextInt);
    }

    @Test
    public void testIntIterableRange() {
        int[] array = {1, 2, 3, 4, 5};
        var iterable = PrimitiveIterables.of(array, 1, 4);
        var it = iterable.iterator();
        for (int i = 1; i < 4; i++) {
            assertTrue(it.hasNext());
            assertEquals(array[i], it.nextInt());
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void testLongIterableStart() {
        long[] array = {10L, 20L, 30L, 40L};
        var iterable = PrimitiveIterables.of(array, 2);
        var it = iterable.iterator();
        assertEquals(30L, it.nextLong());
        assertEquals(40L, it.nextLong());
        assertFalse(it.hasNext());
    }

    @Test
    public void testDoubleIterableEmpty() {
        double[] array = {};
        var iterable = PrimitiveIterables.of(array);
        var it = iterable.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::nextDouble);
    }

    @Test
    public void testNullArray() {
        assertThrows(NullPointerException.class, () -> PrimitiveIterables.of((int[]) null));
        assertThrows(NullPointerException.class, () -> PrimitiveIterables.of((long[]) null, 0));
        assertThrows(NullPointerException.class, () -> PrimitiveIterables.of((double[]) null, 0, 0));
    }

    @Test
    public void testInvalidBounds() {
        int[] array = {1, 2, 3};
        assertThrows(IndexOutOfBoundsException.class, () -> PrimitiveIterables.of(array, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> PrimitiveIterables.of(array, 1, 5));
    }

    @Test
    public void testForEach_Int() {
        int[] array = {5, 6, 7, 8};
        var iterable = PrimitiveIterables.of(array, 1, 3);

        var sum = new AtomicInteger(0);
        iterable.forEach((IntConsumer) sum::addAndGet);
        assertEquals(6 + 7, sum.get());
    }

    @Test
    public void testForEach_Long() {
        long[] array = {10L, 20L, 30L, 40L};
        var iterable = PrimitiveIterables.of(array, 1, 4);

        var sum = new AtomicLong(0);
        iterable.forEach((LongConsumer) sum::addAndGet);
        assertEquals(20L + 30L + 40L, sum.get());
    }

    @Test
    public void testForEach_Double() {
        double[] array = {1.5, 2.5, 3.5};
        var iterable = PrimitiveIterables.of(array);

        var sum = new AtomicReference<>(0.0);
        iterable.forEach((DoubleConsumer) sum::set);
        // Note: This forEach takes boxed Double, so it overwrites sum each time,
        // to sum properly, use a custom Consumer:
        sum.set(0.0);
        iterable.forEach((DoubleConsumer) d -> sum.set(sum.get() + d));
        assertEquals(7.5, sum.get());
    }
}
