// SMALL PROBLEMS 9A PART ONE [Clock]

package SmallProblems9A__3_1;

public final class Clock {
    private int hour;
    private int minute;
    private String amPm;


    public static void main(String[] args) {
        Clock time = new Clock(6, 27, "PM");
        time.advance(30);
    }
    

    public Clock(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        this.amPm = amPm;
    }


    // param is type long so that the advance problem itself works!
    public void advance(long minutes) {
        for (int i = 0; i < minutes; i++) {
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour == 12) {
                    amPm = (amPm.equalsIgnoreCase("AM") ? "PM" : "AM");
                } else if (hour > 12) {
                    hour = 1;
                }
            }
        }
    }


    public final int getHour() {
        return hour;
    }


    public final int getMinute() {
        return minute;
    }


    public final String getAmPm() {
        return amPm;
    }


    public final String toString() {
        String result = hour + ":";
        if (minute < 10) {
            result += "0" + minute;
        } else {
            result += minute;
        }
        result += " " + amPm;
        return result;
    }


    public boolean equals(Object o) {
        if (o instanceof Clock) {
            Clock t = (Clock) o;
            return t.hour == this.hour && t.minute == this.minute && t.amPm.equals(this.amPm);
        } else {
            return false;
        }
    }


    // SMALL PROBLEMS 9A PART ONE [Clock]
    /*
    * Write an instance method named advance that will be placed inside the Clock class to become a part of each Clock object's behavior. The advance method accepts a number of minutes as its parameter and moves your object forward in time by that amount of minutes. The minutes passed could be any non-negative number, even a large number such as 500 or 1000000. If necessary, your object might wrap into the next hour or day, or it might wrap from the morning ("AM") to the evening ("PM") or vice versa. A Clock object doesn't care about what day it is; if you advance by 1 minute from 11:59 PM, it becomes 12:00 AM.
    */
    public void advance(int minutes) {
        if (minutes < 0) {
            // Invalid input, do nothing
            return;
        }

        // Convert the current time to minutes since midnight or noon
        int currentTimeInMinutes = (this.hour % 12) * 60 + this.minute;
        if (this.amPm.equals("PM")) {
            currentTimeInMinutes += 12 * 60; // Convert PM hours to 24-hour format
        }

        // Add the minutes to advance
        currentTimeInMinutes += minutes;

        // Calculate the new time in hours and minutes
        int newTimeInMinutes = currentTimeInMinutes % (24 * 60); // Wrap around if it goes past 24 hours
        this.hour = (newTimeInMinutes / 60) % 12;
        this.minute = newTimeInMinutes % 60;

        // Adjust hour if it's 0
        this.hour = this.hour == 0 ? 12 : this.hour;

        // Determine AM or PM
        this.amPm = (newTimeInMinutes / (12 * 60)) % 2 == 0 ? "AM" : "PM";
    }
}
