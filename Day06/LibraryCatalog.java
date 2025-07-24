package com.bridgelabz;

import java.util.*;
class Node{
    String book;
    Node next;
    Node(String book){
        this.book=book;
    }
}

class LL{
    Node head;
    public void add(String book){
        Node node=new Node(book);
        if(head==null){
            head=node;
            
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=node;
    }
    public void remove(String book){
        if(head==null) return;
        if(head.book.equals(book)){
            head=head.next;
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            if(curr.next.book.equals(book)){
                curr.next=curr.next.next;
                return;
            }
            curr=curr.next;
        }
    }
    
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.book+"\n");
            temp=temp.next;
        }
    }
    public boolean contains(String book){
        Node temp=head;
        while(temp!=null){
            if(temp.book.equals(book)) return true;
            temp=temp.next;
        }
        return false;
    }
}

class LibraryOrganizer {
    Map<String, LL> catalog;
    Set<String> titleSet;

    public LibraryOrganizer() {
        catalog = new HashMap<>();
        titleSet = new HashSet<>();
    }

    public void addBook(String genre, String book) {
        if(titleSet.contains(book)){
            System.out.println("Book already exists"+book);
            return;
        }
        catalog.putIfAbsent(genre, new LL());
        catalog.get(genre).add(book);
        titleSet.add(book);
        System.out.println("Added book: "+book+"to genre: "+genre);

    }
    
    public void removeBook(String genre,String book){
        LL l=catalog.get(genre);
        if(l== null){
            System.out.println("No genre found"+genre);
            return;
        }
        if(l.contains(book)){
            l.remove(book);
            titleSet.remove(book);
            System.out.println("Book removed"+book);
        }else{
            System.out.println("Book Not available");
        }

    }

    public void displayCatalog() {
        System.out.println("Library Catalog:");
        for(Map.Entry<String,LL> entry:catalog.entrySet()){
            System.out.print("genre: "+entry.getKey()+" "+"Title:");
            entry.getValue().display();
        }

    }
}

public class LibraryCatalog {
    public static void main(String[] args) {
        LibraryOrganizer library = new LibraryOrganizer();
		library.addBook("Fantasy", "The Hobbit");
		library.addBook("Fanatasy", "The Silmarillion");
        library.addBook("Science Fiction", "Foundation");
        library.addBook("Science Fiction","I, Robot");
        library.displayCatalog();
        library.removeBook("Science Fiction", "I, Robot");
        library.displayCatalog();
	}
}
