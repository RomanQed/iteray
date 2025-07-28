package com.github.romanqed.jiter;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/**
 * A primitive {@link LongIterable} implementation over a range of a {@code long[]} array.
 * <p>
 * Enables iteration over array segments without boxing.
 */
public final class LongArrayIterable implements LongIterable {
    private final long[] array;
    private final int start;
    private final int end;

    /**
     * Constructs an iterable over the specified {@code long[]} from {@code start} (inclusive) to {@code end} (exclusive).
     *
     * @param array the source array
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     */
    public LongArrayIterable(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public PrimitiveIterator.OfLong iterator() {
        return new LongArrayIterator(array, end, start);
    }

    @Override
    public void forEach(Consumer<? super Long> action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public void forEach(LongConsumer action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public Spliterator.OfLong spliterator() {
        return Spliterators.spliterator(array, start, end, Spliterator.SIZED | Spliterator.IMMUTABLE);
    }
}
