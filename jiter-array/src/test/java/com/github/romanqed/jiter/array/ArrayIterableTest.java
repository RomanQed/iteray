package com.github.romanqed.jiter.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public final class ArrayIterableTest {

    private static <E> boolean equalsIter(Iterable<E> iterable, List<E> list) {
        var it = iterable.iterator();
        var listIt = list.iterator();
        while (it.hasNext()) {
            if (!listIt.hasNext()) {
                return false;
            }
            if (!it.next().equals(listIt.next())) {
                return false;
            }
        }
        return !listIt.hasNext();
    }

    @Test
    public void testFullIterable() {
        var strs = new String[]{"a", "b", "c"};
        var iterable = new ArrayIterable<>(strs, 0, strs.length);
        assertTrue(equalsIter(iterable, List.of("a", "b", "c")));
    }

    @Test
    public void testSliceIterable() {
        var strs = new String[]{"a", "b", "c"};
        var it1 = new ArrayIterable<>(strs, 1, 3);
        var it2 = new ArrayIterable<>(strs, 2, 3);
        var it3 = new ArrayIterable<>(strs, 3, 3);
        assertTrue(equalsIter(it1, List.of("b", "c")));
        assertTrue(equalsIter(it2, List.of("c")));
        assertTrue(equalsIter(it3, List.of()));
    }

    @Test
    public void testIterableCreators() {
        var arr = new String[]{"a", "b", "c", "d"};
        assertThrows(NullPointerException.class, () -> ArrayIterables.of((String[]) null));
        assertThrows(NullPointerException.class, () -> ArrayIterables.of(null, 0));
        assertThrows(NullPointerException.class, () -> ArrayIterables.of(null, 0, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterables.of(arr, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterables.of(arr, 3, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterables.of(arr, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterables.of(arr, 0, 100));

        var it0 = ArrayIterables.of(arr);
        var it1 = ArrayIterables.of(arr, 1);
        var its = ArrayIterables.of(arr, 1, 3);
        assertTrue(equalsIter(it0, List.of("a", "b", "c", "d")));
        assertTrue(equalsIter(it1, List.of("b", "c", "d")));
        assertTrue(equalsIter(its, List.of("b", "c")));
    }

    @Test
    public void testForEachMethod() {
        var arr = new String[]{"x", "y", "z"};
        var result = new ArrayList<String>();
        ArrayIterables.of(arr, 0, 3).forEach(result::add);
        assertEquals(List.of("x", "y", "z"), result);
    }

    @Test
    public void testSpliteratorCharacteristics() {
        var arr = new String[]{"1", "2", "3"};
        var spliterator = ArrayIterables.of(arr).spliterator();
        assertTrue(spliterator.hasCharacteristics(java.util.Spliterator.SIZED));
        assertTrue(spliterator.hasCharacteristics(java.util.Spliterator.IMMUTABLE));
        assertEquals(3, spliterator.estimateSize());
    }
}
