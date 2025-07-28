package com.github.romanqed.jiter.index;

final class Util {
    private Util() {
    }

    static void checkBounds(int length, int start, int end) {
        if (start > end) {
            throw new ArrayIndexOutOfBoundsException("start(" + start + ") > end(" + end + ")");
        }
        if (start < 0) {
            throw new ArrayIndexOutOfBoundsException(start);
        }
        if (end > length) {
            throw new ArrayIndexOutOfBoundsException(end);
        }
    }

    static void checkBounds(int start, int end) {
        if (start < 0) {
            throw new ArrayIndexOutOfBoundsException(start);
        }
        if (start > end) {
            throw new ArrayIndexOutOfBoundsException("start(" + start + ") > end(" + end + ")");
        }
    }
}
