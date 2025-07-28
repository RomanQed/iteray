package com.github.romanqed.iteray;

/**
 * Represents a generic indexed data structure supporting random access and mutation.
 *
 * @param <T> the type of elements stored in this structure
 */
public interface Indexable<T> {

    /**
     * Returns the element at the specified index.
     *
     * @param index the element index
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Replaces the element at the specified index with the specified value.
     *
     * @param index the index of the element to replace
     * @param val the element to store at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void set(int index, T val);
}
