package com.github.romanqed.jiter.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public final class ArrayIteratorTest {

    private static <E> boolean equalsIter(Iterator<E> iterator, List<E> list) {
        var listIt = list.iterator();
        while (iterator.hasNext()) {
            if (!listIt.hasNext()) {
                return false;
            }
            if (!iterator.next().equals(listIt.next())) {
                return false;
            }
        }
        return !listIt.hasNext();
    }

    @Test
    public void testFullIterator() {
        var strs = new String[]{"s1", "s2", "s3"};
        var it = new ArrayIterator<>(strs, strs.length, 0);
        assertTrue(equalsIter(it, List.of("s1", "s2", "s3")));
    }

    @Test
    public void testSliceIterator() {
        var strs = new String[]{"s1", "s2", "s3"};
        var it1 = new ArrayIterator<>(strs, strs.length, 1);
        var it2 = new ArrayIterator<>(strs, strs.length, 2);
        var it3 = new ArrayIterator<>(strs, strs.length, 3);
        assertTrue(equalsIter(it1, List.of("s2", "s3")));
        assertTrue(equalsIter(it2, List.of("s3")));
        assertTrue(equalsIter(it3, List.of()));
    }

    @Test
    public void testIteratorCreators() {
        var arr = new String[]{"s1", "s2", "s3", "s4"};
        assertThrows(NullPointerException.class, () -> ArrayIterators.of(null));
        assertThrows(NullPointerException.class, () -> ArrayIterators.of(null, 0));
        assertThrows(NullPointerException.class, () -> ArrayIterators.of(null, 0, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterators.of(arr, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterators.of(arr, 3, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterators.of(arr, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterators.of(arr, 0, 100));
        var it0 = ArrayIterators.of(arr);
        var it1 = ArrayIterators.of(arr, 1);
        var its = ArrayIterators.of(arr, 1, 3);
        assertTrue(equalsIter(it0, List.of("s1", "s2", "s3", "s4")));
        assertTrue(equalsIter(it1, List.of("s2", "s3", "s4")));
        assertTrue(equalsIter(its, List.of("s2", "s3")));
    }

    @Test
    public void testForEachRemaining() {
        var arr = new String[]{"a", "b", "c"};
        var it = ArrayIterators.of(arr, 1); // should iterate b, c
        List<String> result = new ArrayList<>();
        it.forEachRemaining(result::add);
        assertEquals(List.of("b", "c"), result);
    }

    @Test
    public void testManualNextAndHasNext() {
        var arr = new Integer[]{10, 20, 30};
        var it = ArrayIterators.of(arr);
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
        assertTrue(it.hasNext());
        assertEquals(20, it.next());
        assertTrue(it.hasNext());
        assertEquals(30, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testEmptyArrayIterator() {
        var arr = new String[0];
        var it = ArrayIterators.of(arr);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void testExcessNextCallThrows() {
        var arr = new String[]{"x"};
        var it = ArrayIterators.of(arr);
        assertTrue(it.hasNext());
        assertEquals("x", it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}
