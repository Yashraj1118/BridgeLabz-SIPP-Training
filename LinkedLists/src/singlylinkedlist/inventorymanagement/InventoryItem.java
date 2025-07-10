package singlylinkedlist.inventorymanagement;

public class InventoryItem {
    public String itemName;
    public int itemId;
    public int quantity;
    public double price;
    public InventoryItem next;

    public InventoryItem(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
