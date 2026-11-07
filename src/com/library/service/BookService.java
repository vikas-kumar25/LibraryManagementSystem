package com.library.service;

import com.library.model.Book;

import java.util.ArrayList;

/**********************************************
 Developer Name: Vikas
 BookService HAS-A Book (Association)
 /**********************************************/
public class BookService
{
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book)
    {

        for (Book existingBook : books)
        {
            if (existingBook.getBookId() == book.getBookId())
            {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void updateBook(int bookId, String newTitle, String newAuthor)
    {

        Book book = searchBookById(bookId);

        if (book == null)
        {
            System.out.println("Book not found!");
            return;
        }

        book.setTitle(newTitle);
        book.setAuthor(newAuthor);

        System.out.println("Book updated successfully!");
    }

    public Book searchBookById(int bookId)
    {
        for (Book existingBook : books)
        {
            if (existingBook.getBookId() == bookId)
            {
                return existingBook;
            }
        }
        return null;
    }

    public void deleteBook(int bookId)
    {

        Book book = searchBookById(bookId);

        if (book == null)
        {
            System.out.println("Book not found!");
            return;
        }

        books.remove(book);
        System.out.println("Book deleted successfully!");
    }

    public void displayAllBooks()
    {
        if (books.isEmpty())
        {
            System.out.println("Sorry, No Books Exist! ");
        } else
        {
            for (Book existingBook : books)
            {
                existingBook.displayBookDetails();
            }
        }
    }

}
