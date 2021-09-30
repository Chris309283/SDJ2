import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient
{
  public static void main(String[] args) throws IOException

  {
    final int PORT = 9876;
    final String HOST = "localhost";

    // create an input scanner
    Scanner input = new Scanner(System.in);

    // create a client socket
    DatagramSocket clientSocket = new DatagramSocket();

    // Translate the hostname to IP using DNS
    InetAddress IPAddress = InetAddress.getByName(HOST);
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];

    // Read input from a user
    System.out.println("Write a line for the server: ");
    String sentence = input.nextLine();
    System.out.println("Client> " + sentence);
    sendData = sentence.getBytes();

    // Create a datagram with data to send, length, IP address, port
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
        IPAddress, PORT);

    // Send datagram to server
    clientSocket.send(sendPacket);

    // Read datagram from
    DatagramPacket receivePacket = new DatagramPacket(receiveData,
        receiveData.length);
    clientSocket.receive(receivePacket);
    String modifiedStc = new String(receivePacket.getData()).trim();
    System.out.println("Server> " + modifiedStc);

    // Close connection
    clientSocket.close();
  }
}
