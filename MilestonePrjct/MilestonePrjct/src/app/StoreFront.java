/**
 * 
 */
package app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author David Flores
 *
 */
/**
 * Represents a storefront application where users can interactively purchase items.
 */
public class StoreFront {
    private String name;
    private static InventoryManager inventory;
    private static ShoppingCart cart;
    Scanner scnr = new Scanner(System.in);

    /**
     * Constructs a StoreFront with the provided name, initializes inventory and cart, and adds initial items.
     *
     * @param name The name of the storefront.
     */
    public StoreFront(String name) {
        this.name = name;
        this.inventory = new InventoryManager();
        this.cart = new ShoppingCart();

/*
	        // Adding initial items to the inventory
		Weapon  gun = new Weapon("gun",10, 3, "Range Weapon", 10);
		SalableItem bomb = new Weapon("bomb",20, 3, "splash weapon", 10);
		SalableItem lgtArm = new Armor("Light", 50, 20, "Light Armor", 1 );
		SalableItem hvyArm = new Armor("Heavy", 100, 20, "Heavy Armor", 1 );
		SalableItem fullHlth = new Health("full", 100, 20, "Full Health", 1 );
		
	inventory.addItem(gun);
		inventory.addItem(bomb);
		inventory.addItem(lgtArm);
		inventory.addItem(hvyArm);
		inventory.addItem(fullHlth);
		*/
		 
		inventory.loadInventoryFromFile("/Users/flores/ workspaceCST-239/MilestonePrjct/bin/inventory.json");
		new Thread(this::startCommandListener).start();
		
    
    
    }

    /**
     * Displays the total cost of items in the cart.
     */
    public static void purchase() {
        System.out.println("Your total is: " + cart.getTotal());
    }

    /**
     * Cancels the purchase, returns items to inventory, and empties the cart.
     */
    public static void cancelPurchase() {
        ArrayList<SalableItem> returnInventory = cart.getCart();
        for (int i = 0; i < returnInventory.size(); i++) {
            inventory.addItem(returnInventory.get(i));
        }
        cart.emptyCart();
        System.out.println("Please come back soon!");
    }

    /**
     * Retrieves the name of the storefront.
     *
     * @return The name of the storefront.
     */
    public String getName() {
        return name;
    }

    /**
     * Welcomes the user and guides them through the purchasing process.
     */
    public void WelcomeUser() {
        System.out.println("Hello traveler, welcome to " + name + ", it's dangerous to go alone. Would you like to purchase something? (yes = 1, no = 2)");
        int wantToBuy = scnr.nextInt();

        while (wantToBuy == 1) {
        	
        	// Prompts user to browse by type of item or the entire inventory
        	 System.out.println("What would you like to do?");
             System.out.println("1. Browse items by type");
             System.out.println("2. Display entire inventory");
             int option = scnr.nextInt();

             if (option == 1) {
            	 //prompts user for different types of items to purchase 
                 System.out.println("What type of item would you like to buy?");
                 System.out.println("1. Weapon");
                 System.out.println("2. Armor");
                 System.out.println("3. Health");
                 int itemType = scnr.nextInt();

                 ArrayList<? extends SalableItem> itemsToShow = new ArrayList<>();

                 // Choose appropriate items based on itemType
                 if (itemType == 1) {
                     itemsToShow = (ArrayList<? extends SalableItem>) inventory.getWeaponItems();
                 } else if (itemType == 2) {
                     itemsToShow = (ArrayList<? extends SalableItem>) inventory.getArmorItems();
                 } else if (itemType == 3) {
                     itemsToShow = (ArrayList<? extends SalableItem>) inventory.getHealthItems();
                 }

                 // Display available items of the selected type
                 for (int i = 0; i < itemsToShow.size(); i++) {
                     System.out.println(i + ". " + itemsToShow.get(i));
                 }
             } 
            	 else if (option == 2) {
                     // Display entire inventory
                     System.out.println("Sort options: (-2 to sort by Price Ascending) (-3 to sort by Price Descending) (-4 to sort by Name Ascending) (-5 to sort by Name Descending)");
                     int sortOption = scnr.nextInt();

                     switch (sortOption) {
                         case -2:
                             inventory.sortByPriceAscending();
                             break;
                         case -3:
                             inventory.sortByPriceDescending();
                             break;
                         case -4:
                             inventory.sortInventoryAscending();
                             break;
                         case -5:
                             inventory.sortInventoryDescending();
                             break;
                         default:
                             // No sorting
                             break;
                     }
                     inventory.displayInventory();
             }

             System.out.println("What would you like to buy? Please enter the number. (-1 to quit)");
             //System.out.println("Sort options: (-2 to sort by Price Ascending) (-3 to sort by Price Descending) (-4 to sort by Name Ascending) (-5 to sort by Name Descending)");
             

            int toBuy = scnr.nextInt();
            if (toBuy < 0) {
                break;
           
            }
            if (toBuy < inventory.size()) {
                SalableItem toCart = inventory.getItemFromInventory(toBuy);
                cart.addToCart(toCart);
                inventory.removeItem(toCart);
                cart.getCart();
                System.out.println("Do you want to buy more? (yes = 1, no = 2)");
            } else {
                System.out.println("Your request is out of bounds...NO SOUP FOR YOU!!! NEXT!");
                break;
            }
            wantToBuy = scnr.nextInt();
        }

        if (!cart.isCartEmpty()) {
            StoreFront.purchase();
            System.out.println("Please press 1 to confirm your purchase, or 2 to cancel.");

            int confirm = scnr.nextInt();
            if (confirm == 2) {
                StoreFront.cancelPurchase();
            }
        }

        System.out.println("Have a nice day.");
    }
    /**
     * Starts a command listener that listens for incoming admin commands on port 62626.
     * <p>
     * This method sets up a ServerSocket and continuously listens for incoming connections.
     * Upon receiving a connection, it reads the command from the client and delegates the
     * handling of the command to the handleAdminCommand method.
     */   
 private void startCommandListener() {
        try (ServerSocket serverSocket = new ServerSocket(62626)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String command = in.readLine();
                    handleAdminCommand(command, clientSocket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 /**
  * Handles admin commands received from the AdminTool.
  * <p>
  * This method takes a command and a client socket as parameters. It reads additional
  * data if needed and performs actions based on the command.
  * <ul>
  *     <li>U - Updates the inventory based on a JSON payload</li>
  *     <li>R - Returns the current inventory in JSON format</li>
  * </ul>
  *
  * @param command      The admin command to handle. Expected values are "U" for Update and "R" for Retrieve.
  * @param clientSocket The client socket from which the command was received.
  * @throws IOException If an I/O error occurs while reading from or writing to the socket.
  */    
 private void handleAdminCommand(String command, Socket clientSocket) {
    	 try {
    	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    	        switch (command) {
    	            case "U":
    	                // Read the JSON payload from the AdminTool
    	                String jsonPayload = in.readLine();
    	                // Update the inventory with the new Salable Products
    	                inventory.loadInventoryFromFile("/Users/flores/ workspaceCST-239/MilestonePrjct/bin/inventory.json");
    	                out.println("Inventory updated successfully.");
    	                break;
    	            case "R":
    	                // Return the inventory in JSON format
    	                String inventoryJson = inventory.toJson();
    	                out.println(inventoryJson);
    	                break;
            // Add other cases as needed
            default:
                System.out.println("Unknown admin command received: " + command);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}


    /**
     * Main method to start the store simulation.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        StoreFront store = new StoreFront("The Shop");
        
        store.WelcomeUser();
    }
}