package singlylinkedlist.socialmedia;

public class User {
    public int userId;
    public String name;
    public int age;
    public int[] friendIds; // simple array for friend IDs
    public int friendCount;
    public User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new int[100]; // assuming max 100 friends
        this.friendCount = 0;
        this.next = null;
    }

    public void addFriend(int friendId) {
        for (int i = 0; i < friendCount; i++) {
            if (friendIds[i] == friendId) return; // already friends
        }
        friendIds[friendCount++] = friendId;
    }

    public void removeFriend(int friendId) {
        for (int i = 0; i < friendCount; i++) {
            if (friendIds[i] == friendId) {
                for (int j = i; j < friendCount - 1; j++) {
                    friendIds[j] = friendIds[j + 1];
                }
                friendCount--;
                break;
            }
        }
    }

    public boolean isFriend(int friendId) {
        for (int i = 0; i < friendCount; i++) {
            if (friendIds[i] == friendId) return true;
        }
        return false;
    }

    public void showFriends() {
        System.out.print("Friends of " + name + " (ID: " + userId + "): ");
        if (friendCount == 0) {
            System.out.println("No friends.");
            return;
        }
        for (int i = 0; i < friendCount; i++) {
            System.out.print(friendIds[i] + " ");
        }
        System.out.println();
    }
}
