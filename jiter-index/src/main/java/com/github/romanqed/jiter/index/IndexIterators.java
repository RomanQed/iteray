package com.github.romanqed.jiter.index;

import java.util.Iterator;
import java.util.Objects;

public final class IndexIterators {
    private IndexIterators() {
    }

    public static <E> Iterator<E> of(Indexable<E> indexable, int length) {
        Objects.requireNonNull(indexable);
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        return new IndexIterator<>(indexable, length, 0);
    }

    public static Iterator<Integer> of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterator<>(new IntArrayIndexable(array), end, start);
    }

    public static Iterator<Integer> of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterator<>(new IntArrayIndexable(array), array.length, start);
    }

    public static Iterator<Integer> of(int[] array) {
        Objects.requireNonNull(array);
        return new IndexIterator<>(new IntArrayIndexable(array), array.length, 0);
    }

    public static Iterator<Long> of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterator<>(new LongArrayIndexable(array), end, start);
    }

    public static Iterator<Long> of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterator<>(new LongArrayIndexable(array), array.length, start);
    }

    public static Iterator<Long> of(long[] array) {
        Objects.requireNonNull(array);
        return new IndexIterator<>(new LongArrayIndexable(array), array.length, 0);
    }

    public static Iterator<Double> of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterator<>(new DoubleArrayIndexable(array), end, start);
    }

    public static Iterator<Double> of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterator<>(new DoubleArrayIndexable(array), array.length, start);
    }

    public static Iterator<Double> of(double[] array) {
        Objects.requireNonNull(array);
        return new IndexIterator<>(new DoubleArrayIndexable(array), array.length, 0);
    }
}
