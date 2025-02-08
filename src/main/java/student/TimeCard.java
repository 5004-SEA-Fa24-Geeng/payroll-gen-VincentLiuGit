package student;

public class TimeCard implements ITimeCard{

    private String employee_id;
    private double hours_worked; 

    public TimeCard(String employee_id, double hours_worked) {
        this.employee_id = employee_id;
        this.hours_worked = hours_worked;
    } 

    /**
     * Gets the employee ID.
     * 
     * @return the employee ID
     */
    public String getEmployeeID() {
        return this.employee_id;
    }

    /**
     * Gets the hours worked by the employee.
     * 
     * @return the hours worked by the employee
     */    
    public double getHoursWorked() {
        return this.hours_worked;
    }
}
