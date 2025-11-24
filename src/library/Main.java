package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Book> libBks = new ArrayList<>();
    private static List<Transaction> activeTrans = new ArrayList<>();

    public static void main(String[] args) {
        libBks = LibraryDatabase.loadBooks();
        System.out.println("Loaded " + libBks.size() + " books from database.");
        System.out.println("   UNIVERSITY LIBRARY MANAGEMENT SYSTEM    ");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Librarian (Admin)");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                String input = sc.nextLine();
                int ch = Integer.parseInt(input);

                switch (ch) {
                    case 1: adminMenu(); break;
                    case 2: stdMenu(); break;
                    case 3:
                        // Save before exit
                        LibraryDatabase.saveBooks(libBks);
                        System.out.println("Data saved. Exiting...");
                        System.exit(0);
                    default: System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input.");
            }
        }
    }

    private static void adminMenu() {
        System.out.print("Enter Admin Pass: ");
        String pass = sc.nextLine();
        if (!pass.equals("admin123")) {
            System.out.println("Access Denied!");
            return;
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n[ADMIN] 1. Add Book | 2. View Books | 3. Back");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch(ch) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String auth = sc.nextLine(); 
                    
                    libBks.add(new Book(title, auth, isbn));
                    System.out.println("Book Added!");
                    LibraryDatabase.saveBooks(libBks);
                    break;
                case 2:
                    System.out.println("\n--- LIBRARY INVENTORY ---");
                    for (Book b : libBks) {
                        System.out.println(b);
                    }
                    break;
                case 3: back = true; break;
            }
        }
    }

    private static void stdMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n[STUDENT] 1. Search | 2. Issue Book | 3. Return Book | 4. Back");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch(ch) {
                case 1:
                    System.out.print("Enter Title to Search: ");
                    String qry = sc.nextLine(); // Acronym: query -> qry
                    boolean found = false;
                    for (Book b : libBks) {
                        if (b.getTitle().toLowerCase().contains(qry.toLowerCase())) {
                            System.out.println("FOUND: " + b);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No books found.");
                    break;
                
                case 2:
                    System.out.print("Enter your Student ID: ");
                    String sID = sc.nextLine();
                    System.out.print("Enter Book ISBN to Issue: ");
                    String bISBN = sc.nextLine();
                    
                    Book bkToIssue = null;
                    for (Book b : libBks) {
                        if (b.getIsbn().equals(bISBN) && b.isAvailable()) {
                            bkToIssue = b;
                            break;
                        }
                    }

                    if (bkToIssue != null) {
                        bkToIssue.setAvailable(false);
                        Transaction t = new Transaction(bISBN, sID);
                        activeTrans.add(t);
                        System.out.println("SUCCESS: Book Issued to " + sID);
                        LibraryDatabase.saveBooks(libBks);
                    } else {
                        System.out.println("FAIL: Book not found or already issued.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ISBN to Return: ");
                    String retISBN = sc.nextLine();
                    
                    Book bkToRet = null;
                    for (Book b : libBks) {
                        if (b.getIsbn().equals(retISBN)) {
                            bkToRet = b;
                            break;
                        }
                    }

                    if (bkToRet != null && !bkToRet.isAvailable()) {
                        bkToRet.setAvailable(true);
                        System.out.println("SUCCESS: Book Returned. Check fines in Transaction History.");
                        LibraryDatabase.saveBooks(libBks);
                    } else {
                        System.out.println("FAIL: Book was not borrowed.");
                    }
                    break;

                case 4: back = true; break;
            }
        }
    }
}
