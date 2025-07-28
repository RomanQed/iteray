package com.github.romanqed.jiter.array;

import java.util.Objects;

public final class ArrayIterables {
    private ArrayIterables() {
    }

    public static <E> Iterable<E> of(E[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new ArrayIterable<>(array, start, end);
    }

    public static <E> Iterable<E> of(E[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new ArrayIterable<>(array, start, array.length);
    }

    public static <E> Iterable<E> of(E[] array) {
        Objects.requireNonNull(array);
        return new ArrayIterable<>(array, 0, array.length);
    }
}
