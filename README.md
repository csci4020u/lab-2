# Lab: Java Regular Expression

In this lab, you will be experimenting with the Java regular expression API.

You are to complete the implementation of the `Main` class by:

1. define the missing patterns, and
2. complete the methods.

Ultimately, the objective is that all the test cases should pass.

## Matching

In this part, you are to define a pattern that describes all _valid_ import
statements.

- Define `static Pattern importPattern`
- Implement `static boolean isValidString(Pattern p, String s)`

The unit test `TestRE.TestMatch()` provides 8 assertions to test how your
pattern does against some sample cases.

## Searcher

Here you are to experiment with the search capability of the Java RE library.

- Define `static Pattern classDeclPattern`. The pattern should define a patterns
  of a class declaration.
- Implement `static boolean contains(Pattern p, String s)`.

The unit test `TestRE.TestSearch()` will test how well your pattern and the
search function can locate class declarations in Java.

## Information Extraction

Finally, you are to experiment with the groups in RE.

- Define `static Pattern invokePattern` which describes patterns of object
  method invocations in Java. This pattern must contain _two_ groups
corresponding to the object and the method name.
- Implement the `static String[][] findMatches(Pattern p, String line)`
which returns _all_ instances of the invocation patterns found in the line.

The unit test `TestRE.TestExtract()` will test how well your pattern and the
find functions work against various sample inputs.
