package com.github.romanqed.jiter.primitive;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.LongConsumer;

/**
 * A primitive iterable over {@code long} values, exposing {@link PrimitiveIterator.OfLong}
 * and {@link Spliterator.OfLong}.
 */
public interface LongIterable extends PrimitiveIterable<Long, LongConsumer, Spliterator.OfLong> {

    /**
     * Returns a {@link PrimitiveIterator.OfLong} over the {@code long} elements.
     *
     * @return a primitive long iterator
     */
    @Override
    PrimitiveIterator.OfLong iterator();

    /**
     * Performs the given {@link LongConsumer} action for each {@code long} element.
     *
     * @param action the action to perform on each element
     */
    @Override
    void forEach(LongConsumer action);

    /**
     * Returns a {@link Spliterator.OfLong} over the {@code long} elements.
     *
     * @return a primitive long spliterator
     */
    @Override
    Spliterator.OfLong spliterator();
}
