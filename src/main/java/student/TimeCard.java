package student;

public class TimeCard implements ITimeCard {

    /**
     * employeeId
     */
    private String employeeId;
    /**
     * hoursWorked
     */
    private double hoursWorked; 

    /**
     * Create a TimeCard object.
     * @param employeeId employee id should be a string
     * @param hoursWorked hours worked should be a positive number
     */
    public TimeCard(String employeeId, double hoursWorked) {

        // check String inputs.
        checkStringValue(employeeId, "Employee id");
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
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
        return this.employeeId;
    }

    /**
     * Gets the hours worked by the employee.
     * @return the hours worked by the employee
     */    
    public double getHoursWorked() {
        return this.hoursWorked;
    }
}
