package com.github.romanqed.jiter.primitive;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * A primitive {@link PrimitiveIterator.OfInt} implementation over a subrange of an {@code int[]} array.
 * <p>
 * Immutable and non-thread-safe.
 */
public final class IntArrayIterator implements PrimitiveIterator.OfInt {
    private final int[] array;
    private final int end;
    private int index;

    /**
     * Constructs a new iterator over an {@code int[]} from {@code index} (inclusive) to {@code end} (exclusive).
     *
     * @param array the source array
     * @param end   the end index (exclusive)
     * @param index the starting index (inclusive)
     */
    public IntArrayIterator(int[] array, int end, int index) {
        this.array = array;
        this.end = end;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < end;
    }

    @Override
    public int nextInt() {
        if (index >= end) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    @Override
    public Integer next() {
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
    public void forEachRemaining(IntConsumer action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }
}
