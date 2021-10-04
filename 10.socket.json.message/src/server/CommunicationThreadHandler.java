package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CommunicationThreadHandler
{
  private BufferedReader in;
  private PrintWriter out;
  private Socket socket;
  private String ip;

  public CommunicationThreadHandler(Socket socket)
  {
    this.socket = socket;
  }
}
