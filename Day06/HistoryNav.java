package com.bridgelabz;
class Node {
    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

abstract class NavigationApp {
    abstract void visit(String url);
    abstract void back();
    abstract void forward();
    abstract void showHistory();
}

class BrowserNavigation extends NavigationApp {
    private Node curr;

    public BrowserNavigation() {
        this.curr = null;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        if (curr != null) {
            curr.next = newNode;
            newNode.prev = curr;
        }
        curr = newNode;
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (curr != null && curr.prev != null) {
            curr = curr.prev;
            System.out.println("Moved back to: " + curr.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void forward() {
        if (curr != null && curr.next != null) {
            curr = curr.next;
            System.out.println("Moved forward to: " + curr.url);
        } else {
            System.out.println("No next page.");
        }
    }

    public void showHistory() {
        System.out.println("\nBrowser History:");
        Node temp = curr;
        while (temp != null && temp.prev != null) {
            temp = temp.prev;
        }
        
        while (temp != null) {
            System.out.print(temp.url+"->");
            temp = temp.next;
        }
    }
}

public class HistoryNav {
    public static void main(String[] args) {
        BrowserNavigation browser = new BrowserNavigation();

        browser.visit("https://google.com");
        browser.visit("https://openai.com");
        browser.visit("https://github.com");

        browser.showHistory();

        browser.back();
        browser.showHistory();

        browser.back();
        browser.showHistory();

        browser.forward();
        browser.showHistory();

        browser.visit("https://stackoverflow.com");
        browser.showHistory();
    }
}