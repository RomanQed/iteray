package com.github.romanqed.jiter.primitive;

import java.util.Objects;

public final class PrimitiveIterables {
    private PrimitiveIterables() {
    }

    public static IntIterable of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IntArrayIterable(array, start, end);
    }

    public static IntIterable of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IntArrayIterable(array, start, array.length);
    }

    public static IntIterable of(int[] array) {
        Objects.requireNonNull(array);
        return new IntArrayIterable(array, 0, array.length);
    }

    public static LongIterable of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new LongArrayIterable(array, start, end);
    }

    public static LongIterable of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new LongArrayIterable(array, start, array.length);
    }

    public static LongIterable of(long[] array) {
        Objects.requireNonNull(array);
        return new LongArrayIterable(array, 0, array.length);
    }

    public static DoubleIterable of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new DoubleArrayIterable(array, start, end);
    }

    public static DoubleIterable of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new DoubleArrayIterable(array, start, array.length);
    }

    public static DoubleIterable of(double[] array) {
        Objects.requireNonNull(array);
        return new DoubleArrayIterable(array, 0, array.length);
    }
}
