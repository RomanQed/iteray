package com.github.romanqed.jiter.array;

import java.util.Iterator;
import java.util.Objects;

/**
 * Utility class providing convenient methods to create {@link Iterator} instances over a portion of an array.
 * <p>
 * All returned iterators are immutable and do not support element removal or modification.
 */
public final class ArrayIterators {
    private ArrayIterators() {
    }

    /**
     * Creates an {@link Iterator} over the specified subrange of an array.
     *
     * @param array the source array (must not be {@code null})
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     * @param <E>   the type of elements in the array
     * @return an {@link Iterator} over the specified range
     * @throws NullPointerException      if {@code array} is {@code null}
     * @throws IndexOutOfBoundsException if bounds are invalid
     */
    public static <E> Iterator<E> of(E[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new ArrayIterator<>(array, end, start);
    }

    /**
     * Creates an {@link Iterator} over the subrange of an array starting from {@code start} to the end of the array.
     *
     * @param array the source array (must not be {@code null})
     * @param start the starting index (inclusive)
     * @param <E>   the type of elements in the array
     * @return an {@link Iterator} over the specified range
     * @throws NullPointerException      if {@code array} is {@code null}
     * @throws IndexOutOfBoundsException if {@code start} is out of bounds
     */
    public static <E> Iterator<E> of(E[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new ArrayIterator<>(array, array.length, start);
    }

    /**
     * Creates an {@link Iterator} over the entire array.
     *
     * @param array the source array (must not be {@code null})
     * @param <E>   the type of elements in the array
     * @return an {@link Iterator} over the entire array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public static <E> Iterator<E> of(E[] array) {
        Objects.requireNonNull(array);
        return new ArrayIterator<>(array, array.length, 0);
    }
}
