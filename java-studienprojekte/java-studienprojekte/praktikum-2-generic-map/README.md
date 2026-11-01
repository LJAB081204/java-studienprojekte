# Lab 2: Generic map implementation

- `PM2Map<K,V>`: own implementation of `java.util.Map`, backed by an array of `MapPaar<K,V>` key-value pairs.
- `Person`: `Comparable` class with constructor validation (Guava `Preconditions`), e.g. minimum surname length and no negative child count.
- JUnit tests: `MapTester` for the map, `PersonTest` for `Person`.

Run the tests with `mvn test`.
