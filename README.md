# 📚 Library Management System

## 1. Project Overview

The Library Management System is a console-based Java application developed to manage basic library operations such as book management, member registration, book issuing, book returning, and fine calculation.

The main objective of this project is to understand and implement Object-Oriented Programming (OOP) concepts using Java.

## 2. Developer Information

- **Developer Name:** Vikas
- **Project Name:** Library Management System
- **Programming Language:** Java
- **IDE:** IntelliJ IDEA
- **Application Type:** Console-Based Application
- **Data Storage:** ArrayList (In-Memory Storage)

## 3. Features

### Book Management
- Add new books.
- View all books.
- Search books by Book ID.
- Update book details.
- Delete books.

### Member Management
- Register new members.
- Register Student and Faculty members.
- View all registered members.

### Book Issue and Return
- Issue books to registered members.
- Return issued books.
- Prevent issuing an already-issued book.
- View borrowing records.

### Fine Calculation
- Calculate fines for late book returns.
- Apply a fine of ₹5 per late day.

## 4. Library Rules

| Rule | Description |
|---|---|
| Student Borrow Limit | Maximum 3 books |
| Faculty Borrow Limit | Maximum 5 books |
| Loan Period | 14 days |
| Fine | ₹5 per late day |
| Book Availability | One book copy can be issued to only one member at a time |

## 5. OOP Concepts Implemented

This project demonstrates the following Java concepts:

1. **Class and Object** – Creating objects for books, members, and borrowing records.
2. **Encapsulation** – Using private variables and public getters and setters.
3. **Inheritance** – StudentMember and FacultyMember extend Member.
4. **Polymorphism** – Different member types have different borrowing limits.
5. **Abstraction** – Using an abstract Member class.
6. **Interface** – Using Borrowable and FineCalculable interfaces.
7. **Constructor** – Initializing objects.
8. **this Keyword** – Referring to the current object.
9. **super Keyword** – Calling the parent class constructor.
10. **Static Keyword** – Maintaining shared data such as the borrowing record counter.
11. **Final Keyword** – Defining fixed library constants.
12. **Access Modifiers** – Controlling access to classes, variables, and methods.

## 6. Project Structure

```text
LibraryManagementSystem
│
├── src
│   ├── com
│   │   └── Main.java
│   │
│   └── library
│       ├── LibraryApplication.java
│       │
│       ├── model
│       │   ├── Book.java
│       │   ├── Member.java
│       │   ├── StudentMember.java
│       │   ├── FacultyMember.java
│       │   └── BorrowRecord.java
│       │
│       ├── interfaces
│       │   ├── Borrowable.java
│       │   └── FineCalculable.java
│       │
│       ├── service
│       │   ├── BookService.java
│       │   ├── MemberService.java
│       │   ├── LibraryService.java
│       │   └── FineService.java
│       │
│       └── util
│           └── LibraryConstants.java
│
└── README.md
```

## 7. Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner Class
- LocalDate API

## 8. How to Run the Project

1. Download or clone the project.
2. Open the project in IntelliJ IDEA.
3. Configure Java JDK.
4. Open `Main.java`.
5. Run the `main()` method.
6. Use the console menu to perform library operations.

## 9. Data Storage

This project uses Java ArrayList to store books, members, and borrowing records.

**Note:** Data is stored in memory and is not permanently saved. All records are lost when the application is closed.

## 10. Future Enhancements

- Add MySQL database connectivity.
- Implement permanent data storage.
- Add member update and delete functionality.
- Improve input validation and error handling.
- Develop a graphical user interface.

## 11. Learning Objective

The main objective of this project is to strengthen Java fundamentals and understand how Object-Oriented Programming concepts are used in practical applications.

---

**Developed by Vikas**

*Java Learning Project | Library Management System*