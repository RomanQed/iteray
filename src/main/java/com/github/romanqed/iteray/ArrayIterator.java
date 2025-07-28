package com.github.romanqed.iteray;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * An immutable {@link Iterator} over a portion of an array.
 *
 * @param <T> the type of elements returned by this iterator
 */
public final class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private final int end;
    private int index;

    /**
     * Constructs an iterator over the specified array range.
     *
     * @param array the array to iterate over
     * @param end the exclusive upper bound (must be ≤ array.length)
     * @param index the starting index (inclusive)
     */
    public ArrayIterator(T[] array, int end, int index) {
        this.array = array;
        this.end = end;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < end;
    }

    @Override
    public T next() {
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
    public void forEachRemaining(Consumer<? super T> action) {
        while (index < end) {
            action.accept(array[index++]);
        }
    }
}
