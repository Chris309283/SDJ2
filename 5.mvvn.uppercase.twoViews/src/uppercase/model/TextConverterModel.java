package uppercase.model;

import java.util.ArrayList;

public class TextConverterModel implements TextConverter
{
private ArrayList<String> list;

  public TextConverterModel()
  {
    list = new ArrayList<>();
  }

  public ArrayList<String> getLog()
  {
    return list;
  }

  public int getLogSize()
  {
    return list.size();
  }

  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }

  @Override public void addLog(String log)
  {
    list.add(log);
  }
}
