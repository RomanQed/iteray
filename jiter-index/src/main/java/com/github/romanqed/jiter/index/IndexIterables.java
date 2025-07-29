package com.github.romanqed.jiter.index;

import java.util.Objects;

/**
 * A utility class providing factory methods for creating {@link Iterable} instances
 * over {@link Indexable} and primitive arrays.
 */
public final class IndexIterables {
    private IndexIterables() {
    }

    /**
     * Creates an {@link Iterable} from the specified {@link Indexable} with the given length.
     *
     * @param indexable the source indexable
     * @param length    the number of elements to iterate over
     * @param <E>       the type of elements
     * @return an {@link Iterable} instance
     * @throws NullPointerException           if indexable is null
     * @throws ArrayIndexOutOfBoundsException if length is negative
     */
    public static <E> Iterable<E> of(Indexable<E> indexable, int length) {
        Objects.requireNonNull(indexable);
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        return new IndexIterable<>(indexable, 0, length);
    }

    /**
     * Creates an {@link Iterable} over a subrange of an {@code int[]} array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return an {@link Iterable} of boxed integers
     * @throws NullPointerException           if array is null
     * @throws ArrayIndexOutOfBoundsException if bounds are invalid
     */
    public static Iterable<Integer> of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterable<>(new IntArrayIndexable(array), start, end);
    }

    /**
     * Creates an {@link Iterable} from the specified start index to the end of the {@code int[]} array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @return an {@link Iterable} of boxed integers
     * @throws NullPointerException           if array is null
     * @throws ArrayIndexOutOfBoundsException if start is invalid
     */
    public static Iterable<Integer> of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterable<>(new IntArrayIndexable(array), start, array.length);
    }

    /**
     * Creates an {@link Iterable} over the entire {@code int[]} array.
     *
     * @param array the source array
     * @return an {@link Iterable} of boxed integers
     * @throws NullPointerException if array is null
     */
    public static Iterable<Integer> of(int[] array) {
        Objects.requireNonNull(array);
        return new IndexIterable<>(new IntArrayIndexable(array), 0, array.length);
    }

    /**
     * Creates an {@link Iterable} over a subrange of an {@code long[]} array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return an {@link Iterable} of boxed longs
     * @throws NullPointerException           if array is null
     * @throws ArrayIndexOutOfBoundsException if bounds are invalid
     */
    public static Iterable<Long> of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterable<>(new LongArrayIndexable(array), start, end);
    }

    /**
     * Creates an {@link Iterable} from the specified start index to the end of the {@code long[]} array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @return an {@link Iterable} of boxed longs
     * @throws NullPointerException           if array is null
     * @throws ArrayIndexOutOfBoundsException if start is invalid
     */
    public static Iterable<Long> of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterable<>(new LongArrayIndexable(array), start, array.length);
    }

    /**
     * Creates an {@link Iterable} over the entire {@code long[]} array.
     *
     * @param array the source array
     * @return an {@link Iterable} of boxed longs
     * @throws NullPointerException if array is null
     */
    public static Iterable<Long> of(long[] array) {
        Objects.requireNonNull(array);
        return new IndexIterable<>(new LongArrayIndexable(array), 0, array.length);
    }

    /**
     * Creates an {@link Iterable} over a subrange of an {@code double[]} array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return an {@link Iterable} of boxed doubles
     * @throws NullPointerException           if array is null
     * @throws ArrayIndexOutOfBoundsException if bounds are invalid
     */
    public static Iterable<Double> of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IndexIterable<>(new DoubleArrayIndexable(array), start, end);
    }

    /**
     * Creates an {@link Iterable} from the specified start index to the end of the {@code double[]} array.
     *
     * @param array the source array
     * @param start the start index (inclusive)
     * @return an {@link Iterable} of boxed doubles
     * @throws NullPointerException           if array is null
     * @throws ArrayIndexOutOfBoundsException if start is invalid
     */
    public static Iterable<Double> of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IndexIterable<>(new DoubleArrayIndexable(array), start, array.length);
    }

    /**
     * Creates an {@link Iterable} over the entire {@code double[]} array.
     *
     * @param array the source array
     * @return an {@link Iterable} of boxed doubles
     * @throws NullPointerException if array is null
     */
    public static Iterable<Double> of(double[] array) {
        Objects.requireNonNull(array);
        return new IndexIterable<>(new DoubleArrayIndexable(array), 0, array.length);
    }
}
