package com.hillel.elementary.javageeks.oleg.my_labs.lab_1;

import java.util.Scanner;

public class MinuteToYear {
    public static void main(String[] args) {
        System.out.println("Enter number of minutes:");
        Scanner countMinutes= new Scanner(System.in);
        int minutes=countMinutes.nextInt();
        countMinutes.close();

        int year=minutes/(60*24*365);
        int day=(minutes-(year*60*24*365))/60/24;
        System.out.println(minutes + " minutes is approximately " + year +" years and " + day + " days");

    }
}
