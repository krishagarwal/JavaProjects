package com.company;

public class Senator implements Comparable{
    private String name;
    private int yearsInOffice;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private String party;
    private String state;
    private int termMonth;
    private int termDay;
    private int termYear;

    Senator(String n, int y, int bm, int bd, int by, String p,
            String s, int tm, int td, int ty){
        name = n;
        yearsInOffice = y;
        birthMonth = bm;
        birthDay = bd;
        birthYear = by;
        party = p;
        state = s;
        termMonth = tm;
        termDay = td;
        termYear = ty;
    }

    public int compareTo(Object other){
        Senator otherSen = (Senator)(other);
        String thisName = this.getName();
        String otherName = otherSen.getName();
        return thisName.compareTo(otherName);
    }

    int compareBirthYearTo(Object other){
        Senator otherSen = (Senator)(other);
        int thisYear = this.getBirthYear();
        int otherYear = otherSen.getBirthYear();
        if(thisYear != otherYear) {
            return thisYear - otherYear;
        }
        int thisMonth = this.getBirthMonth();
        int otherMonth = otherSen.getBirthMonth();
        if(thisMonth != otherMonth) {
            return thisMonth - otherMonth;
        }
        int thisDay = this.getBirthDay();
        int otherDay = otherSen.getBirthDay();
        if(thisDay != otherDay){
            return thisDay - otherDay;
        }


        return 0;
    }

    public String toString(){
        return String.format("%-20s %-3d %-3d %-3d %-5d %-12s %-20s %-3d %-3d %-5d",
                name, yearsInOffice, birthMonth, birthDay, birthYear, party, state, termMonth, termDay, termYear);

    }

    private int getBirthMonth() {
        return birthMonth;
    }

    private int getBirthDay() {
        return birthDay;
    }

    private int getBirthYear() {
        return birthYear;
    }

    String getName(){
        return name;
    }
}