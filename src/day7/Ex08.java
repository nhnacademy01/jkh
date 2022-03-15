package day7;

import java.util.Calendar;

public class Ex08 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.FEBRUARY, 16, 20, 30, 40);
        System.out.println(cal);
        System.out.println(cal.getTime());

        System.out.println("year: " + cal.get(Calendar.YEAR));
        System.out.println("month: " + cal.get(Calendar.MONTH));
        System.out.println("date: " + cal.get(Calendar.DATE));
        System.out.println("day of year: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("day of month: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("day of week: " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("day of week in month: " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("am pm: " + cal.get(Calendar.AM_PM));
        System.out.println("hour: " + cal.get(Calendar.HOUR));
        System.out.println("minute: " + cal.get(Calendar.MINUTE));
        System.out.println("second: " + cal.get(Calendar.SECOND));
    }
}
