package com.library.service;

import com.library.interfaces.Borrowable;
import com.library.model.Book;
import com.library.model.BorrowRecord;
import com.library.model.Member;
import com.library.util.LibraryConstants;

import java.time.LocalDate;
import java.util.ArrayList;

/**********************************************
 Developer Name: Vikas

 (Association)
 LibraryService HAS-A BookService
 LibraryService HAS-A MemberService

 (Constructor Injection)
 passing an object through a constructor
 **********************************************/
public class LibraryService implements Borrowable
{
    private static int recordCounter = 1;
    private BookService bookService;
    private MemberService memberService;
    private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();

    public LibraryService(BookService bookService, MemberService memberService)
    {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @Override
    public void issueBook(int bookId, int memberId)
    {

        // Step 1: Find Book and Member
        Book book = bookService.searchBookById(bookId);
        Member member = memberService.searchMemberById(memberId);

        // Step 2: Validate Book and Member
        if (book == null)
        {
            System.out.println("Book not found!");
            return;
        }

        if (member == null)
        {
            System.out.println("Member not found!");
            return;
        }

        // Step 3: Check Book Availability
        if (!book.isAvailable())
        {
            System.out.println("Book is already issued!");
            return;
        }

        // Step 4: Count Currently Issued Books
        int issuedCount = 0;

        for (BorrowRecord record : borrowRecords)
        {

            if (record.getMember().getMemberId() == memberId
                    && !record.isReturned())
            {

                issuedCount++;
            }
        }

        // Step 5: Check Member Borrowing Limit
        if (issuedCount >= member.getBorrowLimit())
        {
            System.out.println("Borrowing limit reached!");
            return;
        }

        // Step 6: Generate Issue Date and Due Date
        LocalDate issueDate = LocalDate.now();

        LocalDate dueDate = issueDate.plusDays(
                LibraryConstants.LOAN_PERIOD_DAYS
        );

        // Step 7: Create BorrowRecord
        BorrowRecord record = new BorrowRecord(
                recordCounter++,
                book,
                member,
                issueDate,
                dueDate
        );

        // Step 8: Store BorrowRecord
        borrowRecords.add(record);

        // Step 9: Update Book Availability
        book.setAvailable(false);

        // Step 10: Display Issue Details
        System.out.println("Book issued successfully!");
        System.out.println("Record ID: " + record.getRecordId());
        System.out.println("Book ID: " + bookId);
        System.out.println("Member ID: " + memberId);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Due Date: " + dueDate);
    }

    @Override
    public void returnBook(int bookId, int memberId)
    {

        // Step 1: Find Book and Member
        Book book = bookService.searchBookById(bookId);
        Member member = memberService.searchMemberById(memberId);

        if (book == null)
        {
            System.out.println("Book not found!");
            return;
        }

        if (member == null)
        {
            System.out.println("Member not found!");
            return;
        }

        // Step 2: Find active BorrowRecord
        BorrowRecord activeRecord = null;

        for (BorrowRecord record : borrowRecords)
        {

            if (record.getBook().getBookId() == bookId
                    && record.getMember().getMemberId() == memberId
                    && !record.isReturned())
            {

                activeRecord = record;
                break;
            }
        }

        // Step 3: Check whether an active record exists
        if (activeRecord == null)
        {
            System.out.println("No active borrowing record found!");
            return;
        }

        // Step 4: Mark the record as returned
        activeRecord.markAsReturned();

        // Step 5: Make the book available
        book.setAvailable(true);

        // Step 6: Calculate Fine
        FineService fineService = new FineService();

        double fine = fineService.calculateFine(activeRecord);

        // Step 7: Display return details
        System.out.println("Book returned successfully!");
        System.out.println("Book ID: " + bookId);
        System.out.println("Member ID: " + memberId);
        System.out.println("Return Date: " + activeRecord.getReturnDate());
        System.out.println("Fine Amount: Rs. " + fine);
    }

    public void displayAllBorrowRecords()
    {

        if (borrowRecords.isEmpty())
        {
            System.out.println("No borrowing records found!");
            return;
        }

        for (BorrowRecord record : borrowRecords)
        {

            System.out.println("Record ID: " + record.getRecordId());
            System.out.println("Book ID: " + record.getBook().getBookId());
            System.out.println("Book Title: " + record.getBook().getTitle());
            System.out.println("Member ID: " + record.getMember().getMemberId());
            System.out.println("Member Name: " + record.getMember().getName());
            System.out.println("Issue Date: " + record.getIssueDate());
            System.out.println("Due Date: " + record.getDueDate());
            System.out.println("Returned: " + record.isReturned());

            if (record.isReturned())
            {
                System.out.println("Return Date: " + record.getReturnDate());
            }

            System.out.println("-------------------------");
        }
    }

}
