package com.github.romanqed.iteray;

/**
 * A boxed {@link Indexable} wrapper over a {@code long[]} array.
 */
public final class LongArrayIndexable implements Indexable<Long> {
    private final long[] array;

    /**
     * Constructs a new indexable view over the given {@code long[]} array.
     *
     * @param array the backing array
     */
    public LongArrayIndexable(long[] array) {
        this.array = array;
    }

    @Override
    public Long get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, Long val) {
        array[index] = val;
    }
}
