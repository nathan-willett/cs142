package a1_CodeStepByStep.src.w8_exercises_A___5_24;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return String.format("%d hours, %d minutes", hours, minutes);
    }

    // Adding the method to add another TimeSpan object
    public void add(TimeSpan span) {
        add(span.getHours(), span.getMinutes());
    }
}

