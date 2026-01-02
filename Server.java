
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    public void run() throws IOException, UnknownHostException {
        int port = 8010;
        ServerSocket socket = new ServerSocket(port); // Create a server socket to listen on port 8010
        socket.setSoTimeout(20000); // Set a timeout of 20 seconds
        while (true) { // Continuously accept client connections
            System.out.println("Server is listening on port: " + port); // Log that the server is listening
            Socket acceptedConnection = socket.accept(); // Accept a client connection
            System.out.println("Connected to " + acceptedConnection.getRemoteSocketAddress()); // Log the connected
                                                                                               // client's address
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true); // Create a PrintWriter
                                                                                                // to send data to the
                                                                                                // client
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream())); // Create
                                                                                                                        // a
                                                                                                                        // BufferedReader
                                                                                                                        // to
                                                                                                                        // read
                                                                                                                        // data
                                                                                                                        // from
                                                                                                                        // the
                                                                                                                        // client
            String clientMessage = fromClient.readLine(); // Read a message from the client
            System.out.println("Client says: " + clientMessage);
            toClient.println("Hello World from the server"); // Send a greeting message to the client
            acceptedConnection.close();

        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
