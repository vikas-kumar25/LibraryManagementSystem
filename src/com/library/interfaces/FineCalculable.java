package com.library.interfaces;

import com.library.model.BorrowRecord;

/**********************************************
 Developer Name: Vikas
 purpose: BorrowRecord ki due date aur return date ke basis par fine calculate karna.
 /**********************************************/
public interface FineCalculable
{
    double calculateFine(BorrowRecord record);
}
