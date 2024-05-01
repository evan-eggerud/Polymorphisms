//Name: Evan Eggerud
//Class: CS 145
//Sources: Deitel & Deitel
//Assignment: Polymorphisms, Date
//Purpose: This class works with the other files given to provide the date for each employee polymorphically. 


public class Date{
    private int year;
    private int month;
    private int day;

    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//This method is the setter, and catches errors based on if there are the wrong number of days, month of the year, and if it's on a leap year or not.
    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }

        if (day <= 0 || day > daysInMonth[month - 1]) {
            throw new IllegalArgumentException("Invalid day for month: " + month);
        }

        if (month == 2 && day == 29 && !isLeapYear(year)) {
            throw new IllegalArgumentException("Invalid day for February in non-leap year: " + year);
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }
//This method determines whether or not the year is a leap year or not
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
//Getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
//This method writes to string the birthdate of the employee
    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }


}