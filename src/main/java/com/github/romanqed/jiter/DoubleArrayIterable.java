package com.github.romanqed.jiter;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/**
 * A primitive {@link DoubleIterable} implementation over a range of a {@code double[]} array.
 * <p>
 * Provides an efficient way to iterate over a contiguous subrange of a primitive array without boxing.
 */
public final class DoubleArrayIterable implements DoubleIterable {
    private final double[] array;
    private final int start;
    private final int end;

    /**
     * Constructs an iterable over the specified {@code double[]} from {@code start} (inclusive) to {@code end} (exclusive).
     *
     * @param array the source array
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     */
    public DoubleArrayIterable(double[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public PrimitiveIterator.OfDouble iterator() {
        return new DoubleArrayIterator(array, end, start);
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public void forEach(DoubleConsumer action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public Spliterator.OfDouble spliterator() {
        return Spliterators.spliterator(array, start, end, Spliterator.SIZED | Spliterator.IMMUTABLE);
    }
}
