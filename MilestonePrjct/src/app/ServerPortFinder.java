package app;
import java.io.IOException;
import java.net.ServerSocket;


public class ServerPortFinder {
    public static int findAvailablePort(int startPort, int endPort) {
        for (int port = startPort; port <= endPort; port++) {
            try (ServerSocket ignored = new ServerSocket(port)) {
                return port;
            } catch (IOException ignored) {
                // Port is in use, try the next one
            }
        }
        throw new RuntimeException("No available port found in the given range");
    }

    
}
