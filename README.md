# Text Transformation

This is an example application to learn the purpose of interfaces.

Create implementations of the `club.texttranformation.tranform.TextTransformer` interface with
the following behavior:

- reverses the text
- converts it to uppercase letters (see [
  java.lang.String.toUpperCase()](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#toUpperCase())
- inserts a new line character `\n` after each dot `.` if the dot `.` is not followed by a new line
  character.

Add instnaces of the implementation to the
[Tranformer array in the Application.java](https://github.com/jstanik/text-transformation/blob/main/src/main/java/club/texttransformation/Application.java#L27).
