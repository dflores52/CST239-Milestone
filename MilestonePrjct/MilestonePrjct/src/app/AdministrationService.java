package app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdministrationService {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
    public void start(int port) throws IOException {
    	
    	
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for a client connection....");

        // Wait for a connection from the client
        clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress());

        // Create PrintWriter and BufferedReader for communication with the client
        out = new PrintWriter(clientSocket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Loop to receive and process incoming messages
        String inputLine;
        while ((inputLine = in.readLine())!=null) {
           

            if (".".equals(inputLine)) {
            	System.out.println("got a message to shut server down.");
                out.println("QUIT");
                break;
            } else {
            	System.out.println("Got a message of: "+ inputLine);
                out.println("OK");
            }
            System.out.println("Server is shut down");
        }


    }
public void cleanup() throws IOException {
    // Close connections
    out.close();
    in.close();
    clientSocket.close();
    serverSocket.close();
}

}
