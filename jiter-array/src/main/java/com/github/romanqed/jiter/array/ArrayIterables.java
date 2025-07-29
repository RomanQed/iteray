package com.github.romanqed.jiter.array;

import java.util.Objects;

/**
 * Utility class providing convenient methods to create {@link Iterable} instances over a portion of an array.
 * <p>
 * All methods return immutable, read-only iterables that do not support modification operations.
 */
public final class ArrayIterables {
    private ArrayIterables() {
    }

    /**
     * Creates an {@link Iterable} over the specified subrange of an array.
     *
     * @param array the source array (must not be {@code null})
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     * @param <E>   the type of elements in the array
     * @return an {@link Iterable} over the specified range
     * @throws NullPointerException      if {@code array} is {@code null}
     * @throws IndexOutOfBoundsException if bounds are invalid
     */
    public static <E> Iterable<E> of(E[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new ArrayIterable<>(array, start, end);
    }

    /**
     * Creates an {@link Iterable} over the subrange of an array starting from {@code start} to the end of the array.
     *
     * @param array the source array (must not be {@code null})
     * @param start the starting index (inclusive)
     * @param <E>   the type of elements in the array
     * @return an {@link Iterable} over the specified range
     * @throws NullPointerException      if {@code array} is {@code null}
     * @throws IndexOutOfBoundsException if {@code start} is out of bounds
     */
    public static <E> Iterable<E> of(E[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new ArrayIterable<>(array, start, array.length);
    }

    /**
     * Creates an {@link Iterable} over the entire array.
     *
     * @param array the source array (must not be {@code null})
     * @param <E>   the type of elements in the array
     * @return an {@link Iterable} over the entire array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public static <E> Iterable<E> of(E[] array) {
        Objects.requireNonNull(array);
        return new ArrayIterable<>(array, 0, array.length);
    }
}
