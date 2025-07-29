package com.github.romanqed.jiter.primitive;

import java.util.PrimitiveIterator;
import java.util.Spliterator;

/**
 * An {@link Iterable} specialized for primitive types, exposing a primitive {@link PrimitiveIterator}
 * and {@link Spliterator.OfPrimitive}.
 *
 * @param <T> the boxed type of the primitive
 * @param <C> the consumer type (e.g., {@link java.util.function.IntConsumer})
 * @param <S> the spliterator type (e.g., {@link Spliterator.OfInt})
 */
public interface PrimitiveIterable<T, C, S extends Spliterator.OfPrimitive<T, C, S>> extends Iterable<T> {

    /**
     * Returns a primitive {@link PrimitiveIterator} over the elements.
     *
     * @return a primitive iterator
     */
    @Override
    PrimitiveIterator<T, C> iterator();

    /**
     * Performs the given action for each element of the iterable using a primitive consumer.
     *
     * @param action the primitive consumer to apply to each element
     */
    void forEach(C action);

    /**
     * Returns a primitive {@link Spliterator}.
     *
     * @return a primitive spliterator
     */
    @Override
    Spliterator.OfPrimitive<T, C, S> spliterator();
}
