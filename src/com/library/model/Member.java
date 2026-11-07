package com.library.model;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public abstract class Member
{
    private int memberId;
    private String name;
    private String email;

    public Member(int memberId, String name, String email)
    {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public abstract int getBorrowLimit();

    public int getMemberId()
    {
        return memberId;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }
}
