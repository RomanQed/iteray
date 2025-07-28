package com.github.romanqed.iteray;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * An immutable {@link Iterator} implementation over an {@link Indexable} range.
 *
 * @param <T> the element type
 */
public final class IndexIterator<T> implements Iterator<T> {
    private final Indexable<T> indexable;
    private final int end;
    private int index;

    /**
     * Creates a new iterator over the given {@link Indexable} from {@code index} (inclusive) to {@code end} (exclusive).
     *
     * @param indexable the underlying indexable source
     * @param end       the end index (exclusive)
     * @param index     the start index (inclusive)
     */
    public IndexIterator(Indexable<T> indexable, int end, int index) {
        this.indexable = indexable;
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
        return indexable.get(index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Immutable iterator");
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        while (index < end) {
            action.accept(indexable.get(index++));
        }
    }
}
