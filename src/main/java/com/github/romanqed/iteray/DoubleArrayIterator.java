package com.github.romanqed.iteray;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/**
 * A primitive {@link PrimitiveIterator.OfDouble} implementation over a subrange of a {@code double[]} array.
 * <p>
 * Immutable and non-thread-safe.
 */
public final class DoubleArrayIterator implements PrimitiveIterator.OfDouble {
    private final double[] array;
    private final int end;
    private int index;

    /**
     * Constructs a new iterator over a {@code double[]} from {@code index} (inclusive) to {@code end} (exclusive).
     *
     * @param array the source array
     * @param end   the end index (exclusive)
     * @param index the starting index (inclusive)
     */
    public DoubleArrayIterator(double[] array, int end, int index) {
        this.array = array;
        this.end = end;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < end;
    }

    @Override
    public double nextDouble() {
        if (index >= end) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    @Override
    public Double next() {
        if (index >= end) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Immutable iterator");
    }

    @Override
    public void forEachRemaining(DoubleConsumer action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }

    @Override
    public void forEachRemaining(Consumer<? super Double> action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }
}
