package com.github.romanqed.jiter.primitive;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * A primitive {@link IntIterable} implementation over a range of an {@code int[]} array.
 * <p>
 * Efficient wrapper for iteration over an array segment without boxing.
 */
public final class IntArrayIterable implements IntIterable {
    private final int[] array;
    private final int start;
    private final int end;

    /**
     * Constructs an iterable over the specified {@code int[]} from {@code start} (inclusive) to {@code end} (exclusive).
     *
     * @param array the source array
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     */
    public IntArrayIterable(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return new IntArrayIterator(array, end, start);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public void forEach(IntConsumer action) {
        for (var i = start; i < end; ++i) {
            action.accept(array[i]);
        }
    }

    @Override
    public Spliterator.OfInt spliterator() {
        return Spliterators.spliterator(array, start, end, Spliterator.SIZED | Spliterator.IMMUTABLE);
    }
}
