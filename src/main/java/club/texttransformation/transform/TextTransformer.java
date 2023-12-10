package club.texttransformation.transform;

/**
 * Implementations of this interface should provide specific text transformations.
 */
public interface TextTransformer {

  /**
   * Returns the name of this text-transformer. This text will be used for GUI purposes.
   *
   * @return the transformator name
   */
  String getName();

  /**
   * Applies the transformation to the {@code sourceText} and returns the result as a new
   * {@code String}.
   *
   * @param sourceText the text to transform
   * @return the transformed value
   */
  String transform(String sourceText);

}
