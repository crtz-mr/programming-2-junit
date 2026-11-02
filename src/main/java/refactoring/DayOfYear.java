package refactoring;

import java.util.HashMap;
import java.util.Map;

/**
 * Smelly Example #1
 *
 * https://web.mit.edu/6.005/www/fa16/classes/04-code-review/
 *
 * Collaboratively authored with contributions from: Saman Amarasinghe, Adam
 * Chlipala, Srini Devadas, Michael Ernst, Max Goldman, John Guttag, Daniel
 * Jackson, Rob Miller, Martin Rinard, and Armando Solar-Lezama.
 *
 * This work is licensed under CC BY-SA 4.0.
 */
public class DayOfYear {

    /**
     * "The day of year (DOY) is the sequential day number starting with day 1 on
     * January 1st."
     *
     * https://nsidc.org/data/user-resources/help-center/day-year-doy-calendar
     *
     * This method calculates the day of the year (1-366) that corresponds to the
     * given month, day of month, and year. January 1st is day 1 of the year and
     * December 31st is day 365 (or 366 in a leap year).
     *
     * @param month      the month (1-12)
     * @param dayOfMonth the day of the month (1-31)
     * @param year       the year
     * @return the day of the year (1-366)
     */
    public static int dayOfYear(int month, int dayOfMonth, int year) {
        /*
         * You are expected to change this method in the exercise in order to fix the
         * bugs in it. You are also expected to improve the method's structure and
         * style to make it more readable and maintainable.
         *
         * You are allowed to throw runtime exceptions, such as
         * IllegalArgumentException, if the inputs are invalid.
         *
         * However, you are *not* allowed to change the method signature (name,
         * parameters, return type).
         */

        // leap years are all numbers divisible by 4
        // if divisible by 100 --> it is not a leap year
        // if it is divisible by 4, 100 and 400 then it is a leap year
        // --> with leap years, february (2) has 29 days instead of usual 28

        // 30 days has sept(9), april(4), june(6), november(11)
        // other months has 31 days, jan(1), march(3), may(5), july(7), august(8),
        // oct(10), dec(12)

        Map<Integer, Integer> days = new HashMap<Integer, Integer>();

        days.put(1, 31); // jan
        days.put(2, 28); // feb
        days.put(3, 31); // mar
        days.put(4, 30); // apr
        days.put(5, 31); // may
        days.put(6, 30); // jun
        days.put(7, 31); // jul
        days.put(8, 31); // aug
        days.put(9, 30); // sep
        days.put(10, 31); // oct
        days.put(11, 30); // nov
        days.put(12, 31); // dec

        boolean leapYear = false;

        if (year % 4 == 0) {
            leapYear = true;
            if (year % 100 == 0 && year % 400 != 0) {
                leapYear = false;
            } else if (year % 100 == 0 && year % 400 == 0) {
                leapYear = true;
            }
        }

        if (leapYear) {
            days.put(2, 29);
        }

        int day = 0;

        if (month == 1) {
            day = dayOfMonth;
        } else if (month > 1) {
            for (int i = 1; i < month; i++) {
                day += days.get(i);
            }
            day += dayOfMonth;
        }

        return day;
    }
}
