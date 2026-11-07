package com.library.model;

import java.time.LocalDate;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class BorrowRecord
{
    private int recordId;
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private boolean isReturned;
    private LocalDate returnDate;

    public BorrowRecord(int recordId, Book book, Member member, LocalDate issueDate, LocalDate dueDate)
    {
        this.recordId = recordId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public int getRecordId()
    {
        return recordId;
    }

    public Book getBook()
    {
        return book;
    }

    public Member getMember()
    {
        return member;
    }

    public LocalDate getIssueDate()
    {
        return issueDate;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public boolean isReturned()
    {
        return isReturned;
    }

    public void markAsReturned()
    {
        this.isReturned = true;
        this.returnDate = LocalDate.now();
    }

    public LocalDate getReturnDate()
    {
        return returnDate;
    }
}
