package com.github.romanqed.jiter;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/**
 * A primitive {@link PrimitiveIterator.OfLong} implementation over a subrange of a {@code long[]} array.
 * <p>
 * Immutable and non-thread-safe.
 */
public final class LongArrayIterator implements PrimitiveIterator.OfLong {
    private final long[] array;
    private final int end;
    private int index;

    /**
     * Constructs a new iterator over a {@code long[]} from {@code index} (inclusive) to {@code end} (exclusive).
     *
     * @param array the source array
     * @param end   the end index (exclusive)
     * @param index the starting index (inclusive)
     */
    public LongArrayIterator(long[] array, int end, int index) {
        this.array = array;
        this.end = end;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < end;
    }

    @Override
    public long nextLong() {
        if (index >= end) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    @Override
    public Long next() {
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
    public void forEachRemaining(LongConsumer action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }

    @Override
    public void forEachRemaining(Consumer<? super Long> action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }
}
