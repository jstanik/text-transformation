package club.texttransformation.transform;

public class NoopTransformer implements TextTransformer {

  @Override
  public String getName() {
    return "No transformation";
  }

  @Override
  public String transform(String sourceText) {
    return sourceText;
  }
}
