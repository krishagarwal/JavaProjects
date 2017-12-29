package com.company;

import java.time.LocalDate;

class RepeatedTask extends Task {

    private int[] repeatValues;
    private LocalDate repeatTill;

    RepeatedTask(String title, int yearDue, int monthDue, int dayDue, int repeatYear, int repeatMonth, int repeatDay, int yearStopRepeat, int monthStopRepeat, int dayStopRepeat){
        super(title, yearDue, monthDue, dayDue);
        repeatValues = new int[]  {repeatYear, repeatMonth, repeatDay};

        String currentYear = String.valueOf(LocalDate.now().getYear());
        String stopRepeatDate = "";

        if(String.valueOf(yearStopRepeat).length() < 4) {
            stopRepeatDate += (currentYear.substring(0, 2));
        }

        if(String.valueOf(yearStopRepeat).length() == 1){
            stopRepeatDate += "0";
        }

        stopRepeatDate += yearStopRepeat + "-";


        if((long)(monthStopRepeat/10) < 1){
            stopRepeatDate += "0";
        }

        stopRepeatDate += monthStopRepeat + "-";

        if((long)(dayStopRepeat/10) < 1){
            stopRepeatDate += "0";
        }

        stopRepeatDate += dayStopRepeat;

        repeatTill = LocalDate.parse(stopRepeatDate);
    }

    void markDone(){

        dueDate = dueDate.plusDays(repeatValues[2]).plusMonths(repeatValues[1]).plusYears(repeatValues[0]);

        if(dueDate.plusDays(repeatValues[2]).plusMonths(repeatValues[1]).plusYears(repeatValues[0]).compareTo(repeatTill) > 1){
            isDone = true;
        }
    }

    int[] getRepeatValues() {
        return repeatValues;
    }

    LocalDate getRepeatTill() {
        return repeatTill;
    }
}
