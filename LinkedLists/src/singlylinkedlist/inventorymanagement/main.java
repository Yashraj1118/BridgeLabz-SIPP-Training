package singlylinkedlist.inventorymanagement;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        InventoryList list = new InventoryList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Menu");
            System.out.println("1. Add Item at End");
            System.out.println("2. Add Item at Beginning");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item");
            System.out.println("7. Display Inventory");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Sort Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name, id, quantity, price: ");
                    list.addItem(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter name, id, quantity, price: ");
                    list.addItemAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter name, id, quantity, price, position: ");
                    list.addItemAtPosition(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter item ID to remove: ");
                    list.removeById(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter item ID and new quantity: ");
                    list.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter item name or ID to search: ");
                    list.search(sc.next());
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    list.calculateTotalValue();
                    break;
                case 9:
                    System.out.print("Sort by (name/price): ");
                    String sortBy = sc.next();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    list.sortInventory(sortBy, asc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }
}
