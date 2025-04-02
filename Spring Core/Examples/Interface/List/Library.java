package com.cts.list;

import java.util.List;

public class Library {
	

    private List<String> books;

    // Setter for dependency injection
    public void setBooks(List<String> books) {
        this.books = books;
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }
}
