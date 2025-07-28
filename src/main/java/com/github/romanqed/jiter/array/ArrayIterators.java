package com.github.romanqed.jiter.array;

import java.util.Iterator;
import java.util.Objects;

public final class ArrayIterators {
    private ArrayIterators() {
    }

    public static <E> Iterator<E> of(E[] array, int start, int end) {
        Objects.requireNonNull(array);
        Util.checkBounds(array.length, start, end);
        return new ArrayIterator<>(array, end, start);
    }

    public static <E> Iterator<E> of(E[] array, int start) {
        Objects.requireNonNull(array);
        Util.checkBounds(start, array.length);
        return new ArrayIterator<>(array, array.length, start);
    }

    public static <E> Iterator<E> of(E[] array) {
        Objects.requireNonNull(array);
        return new ArrayIterator<>(array, array.length, 0);
    }
}
