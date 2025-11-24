package library;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long SUID = 1L;

    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; 
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %-10s | Title: %-20s | Author: %-15s | Available: %s",
                isbn, title, author, (isAvailable ? "Yes" : "No"));
    }
}
