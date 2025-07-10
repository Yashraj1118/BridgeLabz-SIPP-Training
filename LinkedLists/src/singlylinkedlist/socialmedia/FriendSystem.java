package singlylinkedlist.socialmedia;

public class FriendSystem {
    public User head;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newUser;
    }

    public User getUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int id1, int id2) {
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        user1.addFriend(id2);
        user2.addFriend(id1);
        System.out.println("Friend connection added.");
    }

    public void removeFriendConnection(int id1, int id2) {
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        user1.removeFriend(id2);
        user2.removeFriend(id1);
        System.out.println("Friend connection removed.");
    }

    public void displayFriendsOfUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.showFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUser(String key) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(key) || temp.name.equalsIgnoreCase(key)) {
                System.out.println("User found: ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Mutual friends of " + u1.name + " and " + u2.name + ": ");
        boolean any = false;
        for (int i = 0; i < u1.friendCount; i++) {
            if (u2.isFriend(u1.friendIds[i])) {
                System.out.print(u1.friendIds[i] + " ");
                any = true;
            }
        }
        if (!any) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println();
        }
    }

    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.friendCount + " friend(s).");
            temp = temp.next;
        }
    }
}
