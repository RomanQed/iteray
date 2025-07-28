package com.github.romanqed.iteray;

/**
 * A boxed {@link Indexable} wrapper over an {@code int[]} array.
 */
public final class IntArrayIndexable implements Indexable<Integer> {
    private final int[] array;

    /**
     * Constructs a new indexable view over the given {@code int[]} array.
     *
     * @param array the backing array
     */
    public IntArrayIndexable(int[] array) {
        this.array = array;
    }

    @Override
    public Integer get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, Integer val) {
        array[index] = val;
    }
}
