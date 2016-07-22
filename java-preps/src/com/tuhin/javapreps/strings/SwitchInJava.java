package com.tuhin.javapreps.strings;

import java.util.IllegalFormatCodePointException;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class SwitchInJava {

    public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
        String type;
        switch (dayOfWeekArg) {
            case "Monday":
                type = "start";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                type = "Midweek";
                break;
            case "Friday":
                type = "End of week";
                break;
            case "Saturday":
            case "Sunday":
                type = "weekend";
                break;
            default:
                throw new IllegalArgumentException("Not a day! are u crazy!!");
        }
        return type;
    }

    public  static void main(String args[]) {
        String type = new SwitchInJava().getTypeOfDayWithSwitchStatement("Sunday");
        System.out.print(type);
    }
}
