package app;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * AdminTool is a utility for administrators to interact with the StoreFront.
 * It provides a simple command-line interface to send commands to the StoreFront.
 * The supported commands are:
 * <ul>
 *     <li>U - Update the StoreFront</li>
 *     <li>R - Retrieve the inventory from the StoreFront</li>
 *     <li>Q - Quit the AdminTool</li>
 * </ul>
 */
public class AdminTool {

    /**
     * The main method provides a command-line interface for administrators to send commands.
     *
     * @param args Command-line arguments (not used)
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (U, R, or Q to quit):");
            String command = scanner.nextLine().toUpperCase();  // Convert to uppercase
            

            if ("Q".equalsIgnoreCase(command)) {
                System.out.println("Exiting AdminTool...");
                scanner.close();
                break;
            }

            sendCommand(command);
        }
    }

    /**
     * Sends the specified command to the StoreFront via a socket connection.
     * If the command is "R", it retrieves the inventory from the StoreFront and prints it.
     *
     * @param command The command to be sent (U, R, or Q)
     */
    private static void sendCommand(String command) {
        try (Socket socket = new Socket("localhost", 62626);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(command);

            if ("R".equals(command)) {
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    responseBuilder.append(line).append("\n");
                }
                String response = responseBuilder.toString();
                System.out.println("Inventory from StoreFront:");
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
