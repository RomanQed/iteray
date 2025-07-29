package com.github.romanqed.jiter.index;

/**
 * A boxed {@link Indexable} wrapper over a {@code double[]} array.
 */
public final class DoubleArrayIndexable implements Indexable<Double> {
    private final double[] array;

    /**
     * Constructs a new indexable view over the given {@code double[]} array.
     *
     * @param array the backing array
     */
    public DoubleArrayIndexable(double[] array) {
        this.array = array;
    }

    @Override
    public Double get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, Double val) {
        array[index] = val;
    }
}
