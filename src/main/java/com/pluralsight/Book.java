package com.pluralsight;

public class Book {


    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }

    public void setId(int id) { this.id = id; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }

    // Check out method
    public void checkOut(String name) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.checkedOutTo = name;
        }
    }

    // Check in method
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
}
