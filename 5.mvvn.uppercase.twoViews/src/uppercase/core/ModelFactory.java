package uppercase.core;

import uppercase.model.TextConverter;
import uppercase.model.TextConverterModel;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter()
  {
    if (textConverter == null)
    {
      textConverter = new TextConverterModel();
    }
    return textConverter;
  }
}
