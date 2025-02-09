package student;

public class TimeCard implements ITimeCard{

    private String employee_id;
    private double hours_worked; 

    /**
     * Create a TimeCard object.
     * @param employee_id employee id should be a string
     * @param hours_worked hours worked should be a positive number
     */
    public TimeCard(String employee_id, double hours_worked) {

        // check String inputs.
        checkStringValue(employee_id, "Employee id");
        this.employee_id = employee_id;
        this.hours_worked = hours_worked;
    } 

    /**
     * Check if the arguments' value are not null.
     * @param val input value
     * @param var variable name
     * @throws IllegalArgumentException
     */
    public void checkStringValue(String val, String var) {
        if (val == null) {
            String errorMsg = String.format("%s cannot be null.", var);
            throw new IllegalArgumentException(errorMsg);
        }
    };

    /**
     * Gets the employee ID.
     * @return the employee ID
     */
    public String getEmployeeID() {
        return this.employee_id;
    }

    /**
     * Gets the hours worked by the employee.
     * @return the hours worked by the employee
     */    
    public double getHoursWorked() {
        return this.hours_worked;
    }
}
