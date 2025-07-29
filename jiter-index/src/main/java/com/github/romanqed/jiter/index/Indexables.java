package com.github.romanqed.jiter.index;

import java.util.Objects;

/**
 * A utility class providing factory methods to wrap Java arrays in {@link Indexable} views.
 */
public final class Indexables {
    private Indexables() {
    }

    /**
     * Wraps a reference array into an {@link Indexable} instance.
     *
     * @param array the array to wrap
     * @param <E>   the element type
     * @return an indexable view over the array
     * @throws NullPointerException if {@code array} is null
     */
    public static <E> Indexable<E> of(E[] array) {
        Objects.requireNonNull(array);
        return new ArrayIndexable<>(array);
    }

    /**
     * Wraps an {@code int[]} array into an {@link Indexable} of {@link Integer}.
     *
     * @param array the array to wrap
     * @return an indexable view over the array
     * @throws NullPointerException if {@code array} is null
     */
    public static Indexable<Integer> of(int[] array) {
        Objects.requireNonNull(array);
        return new IntArrayIndexable(array);
    }

    /**
     * Wraps a {@code long[]} array into an {@link Indexable} of {@link Long}.
     *
     * @param array the array to wrap
     * @return an indexable view over the array
     * @throws NullPointerException if {@code array} is null
     */
    public static Indexable<Long> of(long[] array) {
        Objects.requireNonNull(array);
        return new LongArrayIndexable(array);
    }

    /**
     * Wraps a {@code double[]} array into an {@link Indexable} of {@link Double}.
     *
     * @param array the array to wrap
     * @return an indexable view over the array
     * @throws NullPointerException if {@code array} is null
     */
    public static Indexable<Double> of(double[] array) {
        Objects.requireNonNull(array);
        return new DoubleArrayIndexable(array);
    }
}
