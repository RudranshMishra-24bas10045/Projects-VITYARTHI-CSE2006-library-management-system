# University Library Management System (Java)

A console-based application designed to manage university library resources, users, and transactions efficiently. This project demonstrates core Java concepts including Object-Oriented Programming, File I/O, and Exception Handling.

## Features
* **Role-Based Access:** Distinct functionalities for Librarians (Admin) and Students.
* **Inventory Control:** Add, remove, and view book records.
* **Search Functionality:** Find books by Title or Author instantly.
* **Transaction Management:** Issue and return books with automated fine calculation logic.
* **Data Persistence:** All data is saved locally using Java Serialization (`library_data.ser`).

## Tech Stack
* **Language:** Java (JDK 17+)
* **Concepts Used:** OOP (Inheritance, Polymorphism), Collections Framework, File Handling, Exception Handling.
* **IDE:** Compatible with VS Code, IntelliJ IDEA, or Eclipse.

## Setup & Installation
1.  Clone the repository:
    ```bash
    git clone (https://github.com/RudranshMishra-24bas10045/Projects-VITYARTHI-CSE2006-library-management-system.git)
    ```
2.  Navigate to the project directory.
3.  Navigate to the source folder:
    ```bash
    cd src
    ```
4.  Compile the source code:
    ```bash
    javac library/*.java
    ```
5.  Run the application:
    ```bash
    java library.Main
    ```

## Testing Instructions
1.  **Admin Login:**
    * Select Option `1` (Librarian).
    * Enter Password: `admin123`.
    * Select "Add Book" and enter details (e.g., ISBN: 101, Title: Java Basics).
2.  **Student Search:**
    * Restart the app or go back to Main Menu.
    * Select Option `2` (Student).
    * Search for "Java Basics" to confirm availability.
3.  **Persistence Test:**
    * Exit the application.
    * Run it again.
    * Check if the book added in Step 1 is still in the "View Books" list.

## Project Structure
```text
src/
└── library/
    ├── Main.java           # Entry point and Menu system
    ├── Book.java           # Data model for Books
    ├── Transaction.java    # Logic for issues/returns
    └── LibraryDatabase.java # Handles File I/O
