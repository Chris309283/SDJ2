package client;

import java.io.IOException;

public class Client
{
  public static void main(String[] args) throws IOException
  {
    TaskListClient tlc = new TaskListClient("localhost",6798);
  }
}
