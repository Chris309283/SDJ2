package socketsuppercase.server.model;

import socketsuppercase.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextManagerImpl implements TextManager{

    private PropertyChangeSupport support;
    private List<LogEntry> logEntries;

    public TextManagerImpl() {
        support = new PropertyChangeSupport(this);
        logEntries = new ArrayList<>();
    }

    @Override
    public String toUpperCase(String str) {
        String result = str.toUpperCase();
        LogEntry logEntry = new LogEntry(str, result);
        logEntries.add(logEntry);
        support.firePropertyChange("NewLogEntry", null, logEntry);
        return result;
    }

    @Override
    public List<LogEntry> getLog() {
        return new ArrayList<>(logEntries);
    }

    @Override public String toLowerCase(String str)
    {
        String result = str.toLowerCase();
        LogEntry logEntry = new LogEntry(str, result);
        logEntries.add(logEntry);
        support.firePropertyChange("NewLogEntry", null, logEntry);
        return result;
    }

    @Override public String toCamelCase(String str)
    {
        String result = camelCase(str);
        LogEntry logEntry = new LogEntry(str, result);
        logEntries.add(logEntry);
        support.firePropertyChange("NewLogEntry", null, logEntry);
        return result;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public String camelCase(String s)
    {
        String[] parts = s.split(" ");
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    private static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
