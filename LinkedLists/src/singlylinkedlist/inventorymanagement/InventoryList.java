package singlylinkedlist.inventorymanagement;

public class InventoryList {
    public InventoryItem head;

    public void addItem(String name, int id, int qty, double price) {
        InventoryItem newItem = new InventoryItem(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }

        InventoryItem temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addItemAtBeginning(String name, int id, int qty, double price) {
        InventoryItem newItem = new InventoryItem(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtPosition(String name, int id, int qty, double price, int position) {
        InventoryItem newItem = new InventoryItem(name, id, qty, price);
        if (position == 0 || head == null) {
            addItemAtBeginning(name, id, qty, price);
            return;
        }

        InventoryItem temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int id, int newQty) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public void search(String key) {
        InventoryItem temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(key) || temp.itemName.equalsIgnoreCase(key)) {
                System.out.println("Found: " + temp.itemName + " | ID: " + temp.itemId + " | Qty: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        InventoryItem temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void display() {
        InventoryItem temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " | ID: " + temp.itemId + " | Qty: " + temp.quantity + " | Price: ₹" + temp.price);
            temp = temp.next;
        }
    }

    public void sortInventory(String sortBy, boolean ascending) {
        head = mergeSort(head, sortBy, ascending);
    }

    public InventoryItem mergeSort(InventoryItem node, String sortBy, boolean asc) {
        if (node == null || node.next == null) return node;

        InventoryItem mid = getMiddle(node);
        InventoryItem nextToMid = mid.next;
        mid.next = null;

        InventoryItem left = mergeSort(node, sortBy, asc);
        InventoryItem right = mergeSort(nextToMid, sortBy, asc);

        return merge(left, right, sortBy, asc);
    }

    public InventoryItem merge(InventoryItem a, InventoryItem b, String sortBy, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortBy.equalsIgnoreCase("name")) {
            condition = asc ? a.itemName.compareTo(b.itemName) <= 0 : a.itemName.compareTo(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, sortBy, asc);
            return a;
        } else {
            b.next = merge(a, b.next, sortBy, asc);
            return b;
        }
    }

    public InventoryItem getMiddle(InventoryItem node) {
        if (node == null) return node;
        InventoryItem slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
