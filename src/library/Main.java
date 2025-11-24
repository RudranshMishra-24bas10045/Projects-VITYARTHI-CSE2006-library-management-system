
package library;

import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);
  private static LibraryDatabase db = new LibraryDatabase();
  public static void main(String[] args) {
    System.out.println("   UNIVERSITY LIBRARY MANAGEMENT SYSTEM    ");
    while (true) {
      System.out.println("\nSelect User Type:");
      System.out.println("1. Librarian (Admin)");
      System.out.println("2. Student");
      System.out.println("3. Exit");
      System.out.print("Enter choice: ");
      try {
        int ch = Integer.parseInt(sc.nextLine());
        switch (ch) {
          case 1:
            adminMenu();
            break;
          case 2:
            studentMenu();
            break;
          case 3:
            System.out.println("Exiting system. Goodbye!");
            System.exit(0);
          default:
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Error: Invalid input. Please enter a number.");
            }
        }
    }

    private static void adminMenu() {
        System.out.print("Enter Admin Password: ");
        String pass = sc.nextLine();
        
        if (!pass.equals("admin123")) {
            System.out.println("Access Denied!");
            return;
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- LIBRARIAN MENU ---");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choice: ");
            
            int ch = Integer.parseInt(sc.nextLine());
            switch(ch) {
                case 1:
                    System.out.println("[Stub] Add Book logic goes here...");
                    break;
                case 2:
                    System.out.println("[Stub] View Books logic goes here...");
                    break;
                case 3:
                    back = true;
                    break;
            }
        }
    }

    private static void studentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Search Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choice: ");
            
            int ch = Integer.parseInt(sc.nextLine());
            switch(ch) {
                case 1:
                    System.out.println("[Stub] Search logic goes here...");
                    break;
                case 2:
                    System.out.println("[Stub] Issue logic goes here...");
                    break;
                case 3:
                    back = true;
                    break;
            }
        }
    }
}
