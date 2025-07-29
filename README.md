# jiter
Lightweight utility for efficient, immutable iteration over Java arrays with slicing support.


## Overview

The **jiter** project consists of three independent Maven modules, each providing specialized iteration utilities:

- **jiter-array** — generic immutable iterable and iterator wrappers around Java arrays (`E[]`) with slicing support.
- **jiter-index** — iteration utilities for indexable data sources (`Indexable<E>` interface), including primitive arrays wrapped by adapter classes.
- **jiter-primitive** — high-performance primitive iterables and iterators (`int`, `long`, `double`) based on Java’s primitive iterator interfaces, designed for minimal overhead and zero boxing.

Each module can be used separately or together depending on your needs.

## Features

- Immutable, efficient iteration over array slices without copying.
- Support for generic arrays and indexable data structures.
- Specialized primitive iteration with `PrimitiveIterator` interfaces.
- Null-safe and bounds-checked APIs.
- Minimal dependencies and lightweight implementations.
- Java 11+ compatible.

## Getting Started

To install it, you will need:

* Java 11+
* Maven/Gradle

## Installing

### Gradle dependency

```Groovy
dependencies {
    implementation 'com.github.romanqed:jiter-array:1.0.0'
    implementation 'com.github.romanqed:jiter-index:1.0.0'
    implementation 'com.github.romanqed:jiter-primitive:1.0.0'
}
```

### Maven dependency

```xml
<dependencies>
    <dependency>
        <groupId>com.github.romanqed</groupId>
        <artifactId>jiter-array</artifactId>
        <version>1.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.github.romanqed</groupId>
        <artifactId>jiter-index</artifactId>
        <version>1.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.github.romanqed</groupId>
        <artifactId>jiter-primitive</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Usage Examples

### jiter-array

```java
String[] data = {"a", "b", "c", "d"};
Iterable<String> iterable = ArrayIterables.of(data, 1, 3); // slice ["b", "c"]
for (String s : iterable) {
    System.out.println(s);
}
```

### jiter-index

```java
Indexable<Integer> indexable = new ArrayIndexable<>(new Integer[]{10, 20, 30});
Iterable<Integer> iterable = IndexIterables.of(indexable, 2); // first 2 elements
for (int value : iterable) {
    System.out.println(value);
}
```

### jiter-primitive

```java
int[] numbers = {1, 2, 3, 4, 5};

// Using PrimitiveIterator.OfInt for iteration
PrimitiveIterator.OfInt it = PrimitiveIterators.of(numbers, 2); // iterate from index 2
while (it.hasNext()) {
    System.out.println(it.nextInt());
}

// Using PrimitiveIterable for enhanced for-loop and functional style
IntIterable intIterable = PrimitiveIterables.of(numbers, 1, 4); // slice [2, 3, 4]
for (int n : intIterable) {
    System.out.println(n);
}

// Using forEach with primitive consumer
intIterable.forEach((IntConsumer) n -> System.out.println("Value: " + n));
```

## Built With

* [Gradle](https://gradle.org) - Dependency management

## Authors

* **[RomanQed](https://github.com/RomanQed)** - *Main work*

See also the list of [contributors](https://github.com/RomanQed/jiter/contributors)
who participated in this project.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details
