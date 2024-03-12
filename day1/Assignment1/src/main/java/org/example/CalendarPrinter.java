package org.example;

public class CalendarPrinter {

    public static void printCalendar(int month, int year) {
        if (isValidInput(month, year)) {
            printHeader();
            printMonthCalendar(month, year);
        } else {
            System.out.println("Invalid inputs. Please provide a valid month and year.");
        }
    }

    private static boolean isValidInput(int month, int year) {
        return month >= 1 && month <= 12 && year > 0;
    }

    private static void printHeader() {
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    private static void printMonthCalendar(int month, int year) {
        int startDay = getStartDay(month, year);
        int numDays = getNumDaysInMonth(month, year);

        int dayOfWeek = 0;

        for (int day = 1; day <= numDays; day++) {
            // Print leading spaces for the first week
            if (day == 1) {
                printSpaces(startDay);
                dayOfWeek = startDay;
            }

            System.out.print(String.format("%2d ", day));

            // Move to the next line for the next week
            if (++dayOfWeek == 7) {
                System.out.println();
                dayOfWeek = 0;
            }
        }

        System.out.println(); // Move to the next line after printing the calendar
    }

    private static int getStartDay(int month, int year) {
        // Implementation to calculate the starting day of the month (e.g., using Zeller's Congruence)
        int h = (day(month, year) + ((13 * (month + 1)) / 5) + year % 100 + ((year % 100) / 4) + ((year / 100) / 4) - 2 * (year / 100)) % 7;
        return (h + 5) % 7; // Adjusting for Sunday being 0 in Java
    }

    private static int day(int month, int year) {
        // Implementation to calculate the day of the week (Zeller's Congruence)
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        return (1 + ((13 * (month + 1)) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;
    }

    private static int getNumDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static void printSpaces(int numSpaces) {
        for (int i = 0; i < numSpaces * 3; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        printCalendar(8, 2018);
    }
}
