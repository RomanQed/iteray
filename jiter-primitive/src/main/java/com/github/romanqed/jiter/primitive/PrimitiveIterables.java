package com.github.romanqed.jiter.primitive;

import java.util.Objects;

/**
 * Utility class providing factory methods to create {@link IntIterable},
 * {@link LongIterable} and {@link DoubleIterable} instances from primitive arrays.
 * <p>
 * All methods check input array non-nullity and bounds. Throws
 * {@link NullPointerException} or {@link IndexOutOfBoundsException} accordingly.
 */
public final class PrimitiveIterables {
    private PrimitiveIterables() {
    }

    /**
     * Creates an {@link IntIterable} over a subrange of the given int array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @param end   the end index, exclusive
     * @return an iterable iterating over array[start:end]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start or end are out of array bounds or invalid
     */
    public static IntIterable of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IntArrayIterable(array, start, end);
    }

    /**
     * Creates an {@link IntIterable} over a subrange starting at {@code start} until the end of the array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @return an iterable iterating over array[start:array.length]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start is out of bounds
     */
    public static IntIterable of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IntArrayIterable(array, start, array.length);
    }

    /**
     * Creates an {@link IntIterable} over the entire int array.
     *
     * @param array the source array, must not be null
     * @return an iterable iterating over the entire array
     * @throws NullPointerException if array is null
     */
    public static IntIterable of(int[] array) {
        Objects.requireNonNull(array);
        return new IntArrayIterable(array, 0, array.length);
    }

    /**
     * Creates a {@link LongIterable} over a subrange of the given long array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @param end   the end index, exclusive
     * @return an iterable iterating over array[start:end]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start or end are out of array bounds or invalid
     */
    public static LongIterable of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new LongArrayIterable(array, start, end);
    }

    /**
     * Creates a {@link LongIterable} over a subrange starting at {@code start} until the end of the array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @return an iterable iterating over array[start:array.length]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start is out of bounds
     */
    public static LongIterable of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new LongArrayIterable(array, start, array.length);
    }

    /**
     * Creates a {@link LongIterable} over the entire long array.
     *
     * @param array the source array, must not be null
     * @return an iterable iterating over the entire array
     * @throws NullPointerException if array is null
     */
    public static LongIterable of(long[] array) {
        Objects.requireNonNull(array);
        return new LongArrayIterable(array, 0, array.length);
    }

    /**
     * Creates a {@link DoubleIterable} over a subrange of the given double array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @param end   the end index, exclusive
     * @return an iterable iterating over array[start:end]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start or end are out of array bounds or invalid
     */
    public static DoubleIterable of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new DoubleArrayIterable(array, start, end);
    }

    /**
     * Creates a {@link DoubleIterable} over a subrange starting at {@code start} until the end of the array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @return an iterable iterating over array[start:array.length]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start is out of bounds
     */
    public static DoubleIterable of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new DoubleArrayIterable(array, start, array.length);
    }

    /**
     * Creates a {@link DoubleIterable} over the entire double array.
     *
     * @param array the source array, must not be null
     * @return an iterable iterating over the entire array
     * @throws NullPointerException if array is null
     */
    public static DoubleIterable of(double[] array) {
        Objects.requireNonNull(array);
        return new DoubleArrayIterable(array, 0, array.length);
    }
}
