package com.pluralsight;

import java.util.Scanner;

public class BookHomeScreen {
    private static Book[] inventory = new Book[20];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeInventory();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Book Store Home Screen =====");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAvailableBooks();
                    break;
                case "2":
                    showCheckedOutBooks();
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void initializeInventory() {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Book(i + 1, "ISBN" + (1000 + i), "Book Title " + (i + 1));
        }
    }

    private static void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %s, Title: %s%n", book.getId(), book.getIsbn(), book.getTitle());
            }
        }
        System.out.println("\nEnter the ID of the book you want to check out, or 0 to go back:");
        int bookId = Integer.parseInt(scanner.nextLine());
        if (bookId == 0) return;

        Book book = findBookById(bookId);
        if (book != null && !book.isCheckedOut()) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            book.checkOut(name);
            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Invalid ID or book is already checked out.");
        }
    }

    private static void showCheckedOutBooks() {
        System.out.println("\nChecked Out Books:");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %s, Title: %s, Checked Out To: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }
        System.out.println("\nEnter 'C' to check in a book or 'X' to return to the home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(bookId);
            if (book != null && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("Book checked in successfully!");
            } else {
                System.out.println("Invalid ID or book is not checked out.");
            }
        }
    }

    private static Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
