package client;

import com.google.gson.Gson;
import model.Message;
import model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StudentClientApp
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 6789;
    final String HOST = "localhost";

    Socket ClientSocket = new Socket(HOST,PORT);
    Scanner inFromUser = new Scanner(System.in);

    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

    PrintWriter outToServer = new PrintWriter(ClientSocket.getOutputStream(),true);

    System.out.println("Enter your name: ");
    String name = inFromUser.nextLine();
    System.out.println("Enter your Student number: ");
    int number = inFromUser.nextInt();
    inFromUser.close();

    Student student = new Student(name,number);
    Gson gson = new Gson();
    String json = gson.toJson(student);

    System.out.println("Client> " + json);
    outToServer.println(json);

    String serverReply = inFromServer.readLine();
    System.out.println("Server> " + serverReply);

    Message reply = gson.fromJson(serverReply, Message.class);
    System.out.println("Message: " + reply);

    ClientSocket.close();
  }
}
