package com.github.romanqed.jiter;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.IntConsumer;

/**
 * A primitive iterable over {@code int} values, exposing {@link PrimitiveIterator.OfInt}
 * and {@link Spliterator.OfInt}.
 */
public interface IntIterable extends PrimitiveIterable<Integer, IntConsumer, Spliterator.OfInt> {

    /**
     * Returns a {@link PrimitiveIterator.OfInt} over the {@code int} elements.
     *
     * @return a primitive int iterator
     */
    @Override
    PrimitiveIterator.OfInt iterator();

    /**
     * Performs the given {@link IntConsumer} action for each {@code int} element.
     *
     * @param action the action to perform on each element
     */
    @Override
    void forEach(IntConsumer action);

    /**
     * Returns a {@link Spliterator.OfInt} over the {@code int} elements.
     *
     * @return a primitive int spliterator
     */
    @Override
    Spliterator.OfInt spliterator();
}
