package singlylinkedlist.socialmedia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FriendSystem system = new FriendSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSocial Media Friend System");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name or ID");
            System.out.println("7. Count Friends of All Users");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID, Name, Age: ");
                    system.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter two User IDs to connect: ");
                    system.addFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter two User IDs to disconnect: ");
                    system.removeFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID to view friends: ");
                    system.displayFriendsOfUser(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter two User IDs to find mutual friends: ");
                    system.findMutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter User Name or ID to search: ");
                    system.searchUser(sc.next());
                    break;
                case 7:
                    system.countAllFriends();
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

