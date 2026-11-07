package com.library.model;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class FacultyMember extends Member
{
    public FacultyMember(int memberId, String name, String email)
    {
        super(memberId, name, email);
    }

    @Override
    public int getBorrowLimit()
    {
        return 5;
    }


}
