package com.github.romanqed.jiter.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class ArrayIteratorTest {

    @Test
    public void testFullIterator() {
        var strs = new String[]{"s1", "s2", "s3"};
        var it = new ArrayIterator<>(strs, strs.length, 0);
        assertTrue(it.hasNext());
        assertEquals("s1", it.next());
        assertTrue(it.hasNext());
        assertEquals("s2", it.next());
        assertTrue(it.hasNext());
        assertEquals("s3", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testSliceIterator() {
        var strs = new String[]{"s1", "s2", "s3"};
        var it1 = new ArrayIterator<>(strs, strs.length, 1);
        var it2 = new ArrayIterator<>(strs, strs.length, 2);
        var it3 = new ArrayIterator<>(strs, strs.length, 3);
        assertTrue(it1.hasNext());
        assertEquals("s2", it1.next());
        assertTrue(it1.hasNext());
        assertEquals("s3", it1.next());
        assertFalse(it1.hasNext());
        assertTrue(it2.hasNext());
        assertEquals("s3", it2.next());
        assertFalse(it2.hasNext());
        assertFalse(it3.hasNext());
    }

    @Test
    public void testIteratorCreators() {

    }
}
