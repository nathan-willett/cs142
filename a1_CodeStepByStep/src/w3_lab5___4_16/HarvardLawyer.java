public class HarvardLawyer extends Lawyer {
    public int getVacationDays() {
        return super.getVacationDays() + 3;
    }

    public double getSalary() {
        return super.getSalary() * 1.2;
    }

    public String getVacationForm() {
        
    }
}
