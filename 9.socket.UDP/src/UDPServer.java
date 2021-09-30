import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 9876;
    System.out.println("Starting Server...");

    //Create UDP server socket at port 9876
    DatagramSocket serverSocket = new DatagramSocket(PORT);

    while (true)
    {
      System.out.println("Waiting for client...");

      //Create a space for receiving datagram
      byte[] receiveData = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

      //Receive datagram from a client
      serverSocket.receive(receivePacket);
      String sentence = new String(receivePacket.getData()).trim();

      //Get the IP address and port number of the client
      InetAddress IPAddress = receivePacket.getAddress();
      int port = receivePacket.getPort();

      System.out.println("Client> " + sentence);
      String capitalizedSentence = sentence.toUpperCase();
      System.out.println("Server> " + capitalizedSentence);

      byte[] sendData = new byte[1024];
      sendData = capitalizedSentence.getBytes();

      //create datagram to send to the client
      DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress,port);

      // write out datagram to socket
      serverSocket.send(sendPacket);

      //loop back and wait for another client connection
    }
  }
}
