package com.github.romanqed.jiter.index;

import java.util.Iterator;
import java.util.Objects;

/**
 * A utility class providing factory methods for creating {@link Iterator} instances
 * over {@link Indexable} and primitive arrays.
 */
public final class IndexIterators {
    private IndexIterators() {
    }

    /**
     * Creates an {@link Iterator} from the specified {@link Indexable} with the given length.
     *
     * @param indexable the source indexable
     * @param length    the number of elements to iterate over
     * @param <E>       the type of elements
     * @return an {@link Iterator} instance
     * @throws NullPointerException           if indexable is null
     * @throws ArrayIndexOutOfBoundsException if length is negative
     */
    public static <E> Iterator<E> of(Indexable<E> indexable, int length) {
        Objects.requireNonNull(indexable);
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        return new IndexIterator<>(indexable, length, 0);
    }

    /**
     * Creates an {@link Iterator} over a subrange of the specified {@code int[]} array.
     * Elements are boxed to {@link Integer}.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return a new {@link Iterator} over the specified range
     * @throws NullPointerException           if {@code array} is {@code null}
     * @throws ArrayIndexOutOfBoundsException if {@code start} or {@code end} is out of bounds, or if {@code start > end}
     */
    public static Iterator<Integer> of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterator<>(new IntArrayIndexable(array), end, start);
    }

    /**
     * Creates an {@link Iterator} over the specified {@code int[]} array,
     * starting from the given {@code start} index to the end of the array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @return a new {@link Iterator} of boxed integers
     * @throws NullPointerException           if {@code array} is {@code null}
     * @throws ArrayIndexOutOfBoundsException if {@code start} is invalid
     */
    public static Iterator<Integer> of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterator<>(new IntArrayIndexable(array), array.length, start);
    }

    /**
     * Creates an {@link Iterator} over the entire {@code int[]} array.
     * Elements are boxed to {@link Integer}.
     *
     * @param array the source array
     * @return a new {@link Iterator} of boxed integers
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public static Iterator<Integer> of(int[] array) {
        Objects.requireNonNull(array);
        return new IndexIterator<>(new IntArrayIndexable(array), array.length, 0);
    }

    /**
     * Creates an {@link Iterator} over a subrange of the specified {@code long[]} array.
     * Elements are boxed to {@link Long}.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return a new {@link Iterator} over the specified range
     * @throws NullPointerException           if {@code array} is {@code null}
     * @throws ArrayIndexOutOfBoundsException if {@code start} or {@code end} is out of bounds, or if {@code start > end}
     */
    public static Iterator<Long> of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterator<>(new LongArrayIndexable(array), end, start);
    }

    /**
     * Creates an {@link Iterator} over the specified {@code long[]} array,
     * starting from the given {@code start} index to the end of the array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @return a new {@link Iterator} of boxed longs
     * @throws NullPointerException           if {@code array} is {@code null}
     * @throws ArrayIndexOutOfBoundsException if {@code start} is invalid
     */
    public static Iterator<Long> of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterator<>(new LongArrayIndexable(array), array.length, start);
    }

    /**
     * Creates an {@link Iterator} over the entire {@code long[]} array.
     * Elements are boxed to {@link Long}.
     *
     * @param array the source array
     * @return a new {@link Iterator} of boxed longs
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public static Iterator<Long> of(long[] array) {
        Objects.requireNonNull(array);
        return new IndexIterator<>(new LongArrayIndexable(array), array.length, 0);
    }

    /**
     * Creates an {@link Iterator} over a subrange of the specified {@code double[]} array.
     * Elements are boxed to {@link Double}.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return a new {@link Iterator} over the specified range
     * @throws NullPointerException           if {@code array} is {@code null}
     * @throws ArrayIndexOutOfBoundsException if {@code start} or {@code end} is out of bounds, or if {@code start > end}
     */
    public static Iterator<Double> of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterator<>(new DoubleArrayIndexable(array), end, start);
    }

    /**
     * Creates an {@link Iterator} over the specified {@code double[]} array,
     * starting from the given {@code start} index to the end of the array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @return a new {@link Iterator} of boxed doubles
     * @throws NullPointerException           if {@code array} is {@code null}
     * @throws ArrayIndexOutOfBoundsException if {@code start} is invalid
     */
    public static Iterator<Double> of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterator<>(new DoubleArrayIndexable(array), array.length, start);
    }

    /**
     * Creates an {@link Iterator} over the entire {@code double[]} array.
     * Elements are boxed to {@link Double}.
     *
     * @param array the source array
     * @return a new {@link Iterator} of boxed doubles
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public static Iterator<Double> of(double[] array) {
        Objects.requireNonNull(array);
        return new IndexIterator<>(new DoubleArrayIndexable(array), array.length, 0);
    }
}
