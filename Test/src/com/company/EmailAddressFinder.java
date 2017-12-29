package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressFinder {


    static boolean validate() {

        Scanner sc = new Scanner(System.in);

        Pattern p = Pattern.compile("(.+)@(.+[.].+)");

        System.out.println("Enter an email address.");

        Matcher m = p.matcher(sc.nextLine());

        if (m.matches()) {
            System.out.println("VALID");
            System.out.printf("UserId: %s%nServer: %s%n", m.group(1), m.group(2));
            return true;
        }

        System.out.println("INVALID" + validate());

        return false;
    }

}
