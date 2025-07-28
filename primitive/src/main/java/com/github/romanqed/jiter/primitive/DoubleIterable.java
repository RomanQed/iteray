package com.github.romanqed.jiter.primitive;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.DoubleConsumer;

/**
 * A primitive iterable over {@code double} values, exposing {@link PrimitiveIterator.OfDouble}
 * and {@link Spliterator.OfDouble}.
 */
public interface DoubleIterable extends PrimitiveIterable<Double, DoubleConsumer, Spliterator.OfDouble> {

    /**
     * Returns a {@link PrimitiveIterator.OfDouble} over the {@code double} elements.
     *
     * @return a primitive double iterator
     */
    @Override
    PrimitiveIterator.OfDouble iterator();

    /**
     * Performs the given {@link DoubleConsumer} action for each {@code double} element.
     *
     * @param action the action to perform on each element
     */
    @Override
    void forEach(DoubleConsumer action);

    /**
     * Returns a {@link Spliterator.OfDouble} over the {@code double} elements.
     *
     * @return a primitive double spliterator
     */
    @Override
    Spliterator.OfDouble spliterator();
}
