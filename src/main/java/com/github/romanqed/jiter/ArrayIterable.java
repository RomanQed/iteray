package com.github.romanqed.jiter;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * An {@link Iterable} view over a portion of an array.
 *
 * @param <T> the type of elements returned by this iterable
 */
public final class ArrayIterable<T> implements Iterable<T> {
    private final T[] array;
    private final int start;
    private final int end;

    /**
     * Constructs an iterable over a range of the given array.
     *
     * @param array the source array
     * @param start the starting index (inclusive)
     * @param end the ending index (exclusive)
     */
    public ArrayIterable(T[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(array, end, start);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliterator(array, start, end, Spliterator.IMMUTABLE);
    }
}
