package com.github.romanqed.jiter;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * A lightweight {@link Iterable} over a range of an {@link Indexable} source.
 *
 * @param <T> the element type
 */
public final class IndexIterable<T> implements Iterable<T> {
    private final Indexable<T> indexable;
    private final int start;
    private final int end;

    /**
     * Constructs an iterable over the specified {@link Indexable} from {@code start} (inclusive) to {@code end} (exclusive).
     *
     * @param indexable the indexable to iterate over
     * @param start     the starting index (inclusive)
     * @param end       the ending index (exclusive)
     */
    public IndexIterable(Indexable<T> indexable, int start, int end) {
        this.indexable = indexable;
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<T> iterator() {
        return new IndexIterator<>(indexable, end, start);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (var i = start; i < end; ++i) {
            action.accept(indexable.get(i));
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliterator(
                new IndexIterator<>(indexable, end, start),
                end - start,
                Spliterator.IMMUTABLE
        );
    }
}
