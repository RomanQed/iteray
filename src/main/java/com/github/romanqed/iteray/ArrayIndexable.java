package com.github.romanqed.iteray;

/**
 * A boxed {@link Indexable} wrapper over a reference array.
 *
 * @param <T> the element type
 */
public final class ArrayIndexable<T> implements Indexable<T> {
    private final T[] array;

    /**
     * Constructs a new indexable view over the given array.
     *
     * @param array the backing array
     */
    public ArrayIndexable(T[] array) {
        this.array = array;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, T val) {
        array[index] = val;
    }
}
