package uppercase.model;

public class TextConverterModel implements TextConverter
{

  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }
}
