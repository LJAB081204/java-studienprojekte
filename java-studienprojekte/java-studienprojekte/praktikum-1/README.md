# Lab 1: Custom I/O streams

**1.1 `NumberInputStream`**: an `InputStream` that wraps a `Reader` and returns the next whitespace-separated number from a text file. Numbers above 255 raise a custom `NumberTooLargeException`, since a stream byte can only hold 0 to 255. Sample input: `zahlen_1.txt`.

**1.2 `Base64Writer`**: a `Writer` subclass that encodes written text as Base64 on its way to any `OutputStream`. Checked with a JUnit test (`test/Base64Test.java`).
