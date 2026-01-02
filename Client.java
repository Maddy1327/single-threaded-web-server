package SingleThreadedProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void run() throws UnknownHostException, IOException {
        int port = 8010; // Specify the port number to connect to
        InetAddress address = InetAddress.getByName("localhost"); // Get the localhost address
        Socket socket = new Socket(address, port); // Create a socket to connect to the server at the specified address
                                                   // and port
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true); // Create a PrintWriter to send data to
                                                                                // the server
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Create a
                                                                                                        // BufferedReader
                                                                                                        // to read data
                                                                                                        // from the
                                                                                                        // server
        toSocket.println("Hello World from socket " + socket.getLocalSocketAddress()); // Send a greeting message to the
                                                                                       // server
        String line = fromSocket.readLine(); // Read a message from the server
        System.out.println("Server replied: " + line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }

    public static void main(String[] args) {
        Client singleThreadedWebServer_Client = new Client();
        try {
            singleThreadedWebServer_Client.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}