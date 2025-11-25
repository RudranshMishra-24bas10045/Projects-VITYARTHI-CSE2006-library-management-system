# University Library Management System

## Problem Statement
University libraries often struggle with manual record-keeping, leading to lost books, calculation errors in overdue fines, and inefficient searching mechanisms. Students and faculty often face delays in checking availability, and librarians spend excessive time manually tracking borrowed items. There is a need for a digital solution to automate the issuing, returning, and tracking of library resources.

## Scope
The "University Library Management System" is a Java-based console application designed to digitize library operations. The scope includes:
1.  **Inventory Management:** Storing details of books (Title, Author, ISBN, Availability).
2.  **User Management:** Handling different roles (Students and Faculty) with different privileges.
3.  **Transaction Processing:** Automating the borrowing and returning process, including logic to calculate overdue fines based on date differences.
4.  **Data Persistence:** Using Java File I/O (Serialization) to save records locally so data is retained after the application closes.

## Target Users
1. **Librarians (Admins):** Responsible for managing the book inventory and viewing transaction history.
2. **Students/Faculty (Members):** Users who need to search for books and view their current borrowed status.

## Features
1. **Authentication:** Secure login for Admins to prevent unauthorized access to inventory controls.
2. **Book Management (CRUD):** Functionality to add, remove, and update book records.
3. **Issue & Return Engine:** Logic to validate borrowing limits and calculate fines automatically (10 units/day after 7 days).
4. **Persistent Storage:** Saves library data to a local `library_data.ser` file.

