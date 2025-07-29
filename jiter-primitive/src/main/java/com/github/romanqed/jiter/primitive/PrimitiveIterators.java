package com.github.romanqed.jiter.primitive;

import java.util.Objects;
import java.util.PrimitiveIterator;

/**
 * Utility class providing factory methods to create primitive iterators
 * ({@link PrimitiveIterator.OfInt}, {@link PrimitiveIterator.OfLong}, {@link PrimitiveIterator.OfDouble})
 * over primitive arrays.
 * <p>
 * All methods check input array non-nullity and bounds. Throws
 * {@link NullPointerException} or {@link IndexOutOfBoundsException} accordingly.
 */
public final class PrimitiveIterators {
    private PrimitiveIterators() {
    }

    /**
     * Creates a primitive int iterator over a subrange of the given int array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @param end   the end index, exclusive
     * @return an iterator iterating over array[start:end]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start or end are out of bounds or invalid
     */
    public static PrimitiveIterator.OfInt of(int[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new IntArrayIterator(array, end, start);
    }

    /**
     * Creates a primitive int iterator over a subrange starting at {@code start} until the end of the array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @return an iterator iterating over array[start:array.length]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start is out of bounds
     */
    public static PrimitiveIterator.OfInt of(int[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new IntArrayIterator(array, array.length, start);
    }

    /**
     * Creates a primitive int iterator over the entire int array.
     *
     * @param array the source array, must not be null
     * @return an iterator iterating over the entire array
     * @throws NullPointerException if array is null
     */
    public static PrimitiveIterator.OfInt of(int[] array) {
        Objects.requireNonNull(array);
        return new IntArrayIterator(array, array.length, 0);
    }

    /**
     * Creates a primitive long iterator over a subrange of the given long array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @param end   the end index, exclusive
     * @return an iterator iterating over array[start:end]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start or end are out of bounds or invalid
     */
    public static PrimitiveIterator.OfLong of(long[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new LongArrayIterator(array, end, start);
    }

    /**
     * Creates a primitive long iterator over a subrange starting at {@code start} until the end of the array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @return an iterator iterating over array[start:array.length]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start is out of bounds
     */
    public static PrimitiveIterator.OfLong of(long[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new LongArrayIterator(array, array.length, start);
    }

    /**
     * Creates a primitive long iterator over the entire long array.
     *
     * @param array the source array, must not be null
     * @return an iterator iterating over the entire array
     * @throws NullPointerException if array is null
     */
    public static PrimitiveIterator.OfLong of(long[] array) {
        Objects.requireNonNull(array);
        return new LongArrayIterator(array, array.length, 0);
    }

    /**
     * Creates a primitive double iterator over a subrange of the given double array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @param end   the end index, exclusive
     * @return an iterator iterating over array[start:end]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start or end are out of bounds or invalid
     */
    public static PrimitiveIterator.OfDouble of(double[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new DoubleArrayIterator(array, end, start);
    }

    /**
     * Creates a primitive double iterator over a subrange starting at {@code start} until the end of the array.
     *
     * @param array the source array, must not be null
     * @param start the start index, inclusive (0-based)
     * @return an iterator iterating over array[start:array.length]
     * @throws NullPointerException           if array is null
     * @throws IndexOutOfBoundsException      if start is out of bounds
     */
    public static PrimitiveIterator.OfDouble of(double[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new DoubleArrayIterator(array, array.length, start);
    }

    /**
     * Creates a primitive double iterator over the entire double array.
     *
     * @param array the source array, must not be null
     * @return an iterator iterating over the entire array
     * @throws NullPointerException if array is null
     */
    public static PrimitiveIterator.OfDouble of(double[] array) {
        Objects.requireNonNull(array);
        return new DoubleArrayIterator(array, array.length, 0);
    }
}
