package com.bridgelabz;

class Node {
    String title;
    Node next;
    
    Node(String title) {
        this.title = title;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    
    public void add(String song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            return;
        } 
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void remove(String song) {
        if (head == null) return;
        if (head.title.equals(song)) {
            head = head.next;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.title.equals(song)) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.title);
            current = current.next;
        }
    }
    
    public Node getHead() {
    return head;
}

}

abstract class MediaPlayer {
    public abstract void addSong(String song);
    public abstract void displayPlaylist();
    public abstract void playNext();
}

class MusicPlayer extends MediaPlayer {
    MyLinkedList playlist = new MyLinkedList();
    Node curr = null;

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added song : " + song);
    }

    public void displayPlaylist() {
        System.out.println();
        System.out.println("Current Playlist contains:");
        playlist.display();
    }
    
    public void playNext() {
        if (curr == null) {
            curr = playlist.getHead();
        } else {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("No more songs in playlist.");
        } else {
            System.out.println("Next song to be played: " + curr.next.title);
        }
    }
}

public class MusicPlaylist {
    public static void main(String[] args) {
        MediaPlayer player = new MusicPlayer();

        player.addSong("Shape of You");
        player.addSong("Blinding Lights");
        player.addSong("Levitating");
        player.displayPlaylist();
        
        player.playNext();
    }
}


