package com.library.service;

import com.library.interfaces.FineCalculable;
import com.library.model.BorrowRecord;
import com.library.util.LibraryConstants;

import java.time.LocalDate;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class FineService implements FineCalculable
{
    @Override
    public double calculateFine(BorrowRecord record)
    {
        if (!record.isReturned())
        {
            return 0.0;
        }

        LocalDate returnDate = record.getReturnDate();
        LocalDate dueDate = record.getDueDate();

        long lateDays = java.time.temporal.ChronoUnit.DAYS
                .between(dueDate, returnDate);

        if (lateDays <= 0)
        {
            return 0.0;
        }

        return lateDays * LibraryConstants.FINE_PER_DAY;
    }
}
