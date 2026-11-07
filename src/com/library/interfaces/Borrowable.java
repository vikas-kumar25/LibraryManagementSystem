package com.library.interfaces;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public interface Borrowable
{
    void issueBook(int bookId, int memberId);

    void returnBook(int bookId, int memberId);
}
