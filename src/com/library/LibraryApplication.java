package com.library;

import com.library.service.BookService;
import com.library.service.MemberService;
import com.library.service.LibraryService;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.StudentMember;
import com.library.model.FacultyMember;

import java.util.Scanner;

/******************************************
 Developer Name: Vikas
 Project: Library Management System
 *****************************************/

public class LibraryApplication
{

    private final Scanner scanner = new Scanner(System.in);
    private BookService bookService;
    private MemberService memberService;
    private LibraryService libraryService;

    // Application starting method
    public void start()
    {

        initializeServices();

        System.out.println("\n=================================");
        System.out.println("  LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=================================");

        showMenu();
    }

    // Initialize services
    private void initializeServices()
    {

        bookService = new BookService();
        memberService = new MemberService();

        libraryService = new LibraryService(
                bookService,
                memberService
        );

        System.out.println("Library services initialized!");
    }

    // Display main menu
    private void showMenu()
    {

        boolean running = true;

        while (running)
        {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Register Member");
            System.out.println("7. View All Members");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. View Borrowing Records");
            System.out.println("11. Exit");
            System.out.println("===============================");

            int choice = readInt("Enter your choice: ");

            switch (choice)
            {

                case 1:
                    addBook();
                    break;

                case 2:
                    bookService.displayAllBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    updateBook();
                    break;

                case 5:
                    deleteBook();
                    break;

                case 6:
                    registerMember();
                    break;

                case 7:
                    memberService.displayAllMembers();
                    break;

                case 8:
                    issueBook();
                    break;

                case 9:
                    returnBook();
                    break;

                case 10:
                    libraryService.displayAllBorrowRecords();
                    break;

                case 11:
                    running = false;
                    System.out.println(
                            "Thank you for using Library Management System!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please try again."
                    );
                    break;
            }
        }

    }

    // Add a new book
    private void addBook()
    {

        System.out.println("\n--- ADD BOOK ---");

        int bookId = readInt("Enter Book ID: ");

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        Book book = new Book(bookId, title, author, true);

        bookService.addBook(book);
    }

    // Search book by ID
    private void searchBook()
    {

        System.out.println("\n--- SEARCH BOOK ---");

        int bookId = readInt("Enter Book ID: ");

        Book book = bookService.searchBookById(bookId);

        if (book == null)
        {
            System.out.println("Book not found!");
        } else
        {
            book.displayBookDetails();
        }
    }

    // Register a new member
    private void registerMember()
    {

        System.out.println("\n--- REGISTER MEMBER ---");

        System.out.println("1. Student");
        System.out.println("2. Faculty");

        int memberType = readInt("Select Member Type: ");

        if (memberType != 1 && memberType != 2)
        {
            System.out.println("Invalid member type!");
            return;
        }

        int memberId = readInt("Enter Member ID: ");

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Member Email: ");
        String email = scanner.nextLine();

        Member member;

        if (memberType == 1)
        {
            member = new StudentMember(memberId, name, email);
        } else
        {
            member = new FacultyMember(memberId, name, email);
        }

        memberService.registerMember(member);
    }

    // Issue a book
    private void issueBook()
    {

        System.out.println("\n--- ISSUE BOOK ---");

        int bookId = readInt("Enter Book ID: ");
        int memberId = readInt("Enter Member ID: ");

        libraryService.issueBook(bookId, memberId);
    }

    // Return a book
    private void returnBook()
    {

        System.out.println("\n--- RETURN BOOK ---");

        int bookId = readInt("Enter Book ID: ");
        int memberId = readInt("Enter Member ID: ");

        libraryService.returnBook(bookId, memberId);
    }

    // Read integer input safely
    private int readInt(String message)
    {

        while (true)
        {

            System.out.print(message);

            String input = scanner.nextLine();

            try
            {
                return Integer.parseInt(input);
            } catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Update existing book
    private void updateBook()
    {

        System.out.println("\n--- UPDATE BOOK ---");

        int bookId = readInt("Enter Book ID: ");

        Book book = bookService.searchBookById(bookId);

        if (book == null)
        {
            System.out.println("Book not found!");
            return;
        }

        System.out.print("Enter New Book Title: ");
        String newTitle = scanner.nextLine();

        System.out.print("Enter New Author Name: ");
        String newAuthor = scanner.nextLine();

        bookService.updateBook(bookId, newTitle, newAuthor);
    }

    // Delete existing book
    private void deleteBook()
    {

        System.out.println("\n--- DELETE BOOK ---");

        int bookId = readInt("Enter Book ID: ");

        bookService.deleteBook(bookId);
    }
}

