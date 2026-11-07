package com.library.service;

import com.library.model.Member;

import java.util.ArrayList;

/**********************************************
 Developer Name: Vikas
 MemberService HAS-A Member (Association)
 /**********************************************/
public class MemberService
{
    private ArrayList<Member> members = new ArrayList<>();

    public void registerMember(Member member)
    {

        for (Member existingMember : members)
        {
            if (existingMember.getMemberId() == member.getMemberId())
            {
                System.out.println("Member ID already exists!");
                return;
            }
        }

        members.add(member);
        System.out.println("Member registered successfully!");
    }

    public Member searchMemberById(int memberId)
    {

        for (Member existingMember : members)
        {
            if (existingMember.getMemberId() == memberId)
            {
                return existingMember;
            }
        }

        return null;
    }

    public void displayAllMembers()
    {

        if (members.isEmpty())
        {
            System.out.println("No members registered!");
            return;
        }

        for (Member member : members)
        {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Borrow Limit: " + member.getBorrowLimit());
            System.out.println("----------------------");
        }
    }
}
