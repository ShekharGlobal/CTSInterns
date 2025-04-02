package com.cts.map;
import java.util.Map;

public class Library {
    private Map<String, String> books;

    // Setter for dependency injection
    public void setBooks(Map<String, String> books) {
        this.books = books;
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Map.Entry<String, String> entry : books.entrySet()) {
            System.out.println("- " + entry.getKey() + " by " + entry.getValue());
        }
    }
}
