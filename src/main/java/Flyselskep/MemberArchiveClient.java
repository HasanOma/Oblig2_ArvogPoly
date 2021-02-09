package Flyselskep;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;

/**
 * A simple client program to test the functionality of the
 * MemberArchive and underlaying classes.
 *
 * @author arne
 */
public class MemberArchiveClient {

    public static void main(String[] args) {
        MemberArchive memberArchive = new MemberArchive();

        memberArchive.fillRegisterWithTestdata();

        for (BonusMember member: memberArchive.allMembers()){
            System.out.println(member.toString());
        }



        System.out.println("\nAdd some bonuspoints to all of the members..\n");

        System.out.println("Member 1 gets 10.000");
        memberArchive.registerPoints(1, 10000);

        System.out.println("Member 2 gets 10.000");
        memberArchive.registerPoints(2, 10000);

        System.out.println("Member 3 gets 10.000");
        memberArchive.registerPoints(3, 10000);

        System.out.println("Member 4 gets 10.000");
        memberArchive.registerPoints(4, 10000);

        System.out.println("Member 5 gets 10.000");
        memberArchive.registerPoints(5, 10000);

        System.out.println("Now lets see the register:\n");
        for (BonusMember member: memberArchive.allMembers()){
            System.out.println(member.toString());
        }


//        BonusMember newMember = new BonusMember(6, LocalDate.now(), 45000, "Olsen, ben", "ben@olsen.biz");
//        memberArchive.addMember(newMember);
//        BonusMember newMember2 = new BonusMember(7, LocalDate.now(), 70000, "Olsen, ken", "ken@olsen.biz");
//        memberArchive.addMember(newMember2);
//        BonusMember newMember3 = new BonusMember(8, LocalDate.now(), 80000, "Olsen, jon", "jon@olsen.biz");
//        memberArchive.addMember(newMember3);
//        BonusMember newMember4 = new BonusMember(9, LocalDate.now(), 9000, "Olsen, sven", "sven@olsen.biz");
//        memberArchive.addMember(newMember4); //Adding members trough addMember method

        System.out.println("Now lets see the register:\n");
        for (BonusMember member: memberArchive.allMembers()){
            System.out.println(member.toString());
        }


    }
}