package SmallProblems2A__1_10;

public class ComputePay {
    public static void main(String[] args) {
        // Calculate pay at work based on hours worked each day
        int hoursWorked = 4 + 5 + 8 + 4;
        double hourlySalary = 8.75;
        double totalPay = hoursWorked * hourlySalary;
        double taxRate = 0.20;
        double taxesOwed = totalPay * taxRate;

        System.out.println("My total hours worked:");
        System.out.println(hoursWorked);

        System.out.println("My hourly salary:");
        System.out.println("$" + hourlySalary);

        System.out.println("My total pay:");
        System.out.println(totalPay);

        System.out.println("My taxes owed:"); // 20% tax
        System.out.println(taxesOwed);
    }
}