package com.github.romanqed.jiter.index;

import java.util.Objects;

public final class IndexIterables {
    private IndexIterables() {
    }

    public static <E> Iterable<E> of(Indexable<E> indexable, int length) {
        Objects.requireNonNull(indexable);
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        return new IndexIterable<>(indexable, 0, length);
    }

    public static Iterable<Integer> of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterable<>(new IntArrayIndexable(array), start, end);
    }

    public static Iterable<Integer> of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterable<>(new IntArrayIndexable(array), start, array.length);
    }

    public static Iterable<Integer> of(int[] array) {
        Objects.requireNonNull(array);
        return new IndexIterable<>(new IntArrayIndexable(array), 0, array.length);
    }

    public static Iterable<Long> of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterable<>(new LongArrayIndexable(array), start, end);
    }

    public static Iterable<Long> of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterable<>(new LongArrayIndexable(array), start, array.length);
    }

    public static Iterable<Long> of(long[] array) {
        Objects.requireNonNull(array);
        return new IndexIterable<>(new LongArrayIndexable(array), 0, array.length);
    }

    public static Iterable<Double> of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterable<>(new DoubleArrayIndexable(array), start, end);
    }

    public static Iterable<Double> of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterable<>(new DoubleArrayIndexable(array), start, array.length);
    }

    public static Iterable<Double> of(double[] array) {
        Objects.requireNonNull(array);
        return new IndexIterable<>(new DoubleArrayIndexable(array), 0, array.length);
    }
}
