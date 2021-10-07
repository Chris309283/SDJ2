package socketsuppercase.client.model;

import socketsuppercase.client.network.Client;
import socketsuppercase.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class TextConverterManager implements TextConverter
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;

  public TextConverterManager(Client client)
  {
    this.client = client;
    client.startClient();
    client.addListener("NewLogEntry", this::onNewLogEntry);
  }

  private void onNewLogEntry(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public String toUpperCase(String text)
  {
    return client.toUpperCase(text);
  }

  @Override public List<LogEntry> getLogs()
  {
    return client.getLog();
  }

  @Override public String toLowerCase(String text)
  {
    return text.toLowerCase();
  }

  @Override public String toCamelCase(String s)
  {
    String[] parts = s.split(" ");
    String camelCaseString = "";
    for (String part : parts)
    {
      camelCaseString = camelCaseString + toProperCase(part);
    }
    return camelCaseString;
  }

  private static String toProperCase(String s)
  {
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}


