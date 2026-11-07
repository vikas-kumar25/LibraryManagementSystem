package com.library.model;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class StudentMember extends Member
{
    public StudentMember(int memberId, String name, String email)
    {
        super(memberId, name, email);

    }

    @Override
    public int getBorrowLimit()
    {
        return 3;
    }
}
