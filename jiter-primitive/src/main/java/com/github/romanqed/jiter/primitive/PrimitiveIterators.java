package com.github.romanqed.jiter.primitive;

import java.util.Objects;
import java.util.PrimitiveIterator;

public final class PrimitiveIterators {
    private PrimitiveIterators() {
    }

    public static PrimitiveIterator.OfInt of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IntArrayIterator(array, end, start);
    }

    public static PrimitiveIterator.OfInt of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IntArrayIterator(array, array.length, start);
    }

    public static PrimitiveIterator.OfInt of(int[] array) {
        Objects.requireNonNull(array);
        return new IntArrayIterator(array, array.length, 0);
    }

    public static PrimitiveIterator.OfLong of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new LongArrayIterator(array, end, start);
    }

    public static PrimitiveIterator.OfLong of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new LongArrayIterator(array, array.length, start);
    }

    public static PrimitiveIterator.OfLong of(long[] array) {
        Objects.requireNonNull(array);
        return new LongArrayIterator(array, array.length, 0);
    }

    public static PrimitiveIterator.OfDouble of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new DoubleArrayIterator(array, end, start);
    }

    public static PrimitiveIterator.OfDouble of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new DoubleArrayIterator(array, array.length, start);
    }

    public static PrimitiveIterator.OfDouble of(double[] array) {
        Objects.requireNonNull(array);
        return new DoubleArrayIterator(array, array.length, 0);
    }
}
