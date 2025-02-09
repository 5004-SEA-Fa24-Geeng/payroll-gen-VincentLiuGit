package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractEmployee implements IEmployee {
    private TypeOfEmployee employeeType;
    private String employeeName;
    private String employeeId;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;

    /**
     * Create an employee object.
     * @param employeeType employee type
     * @param employeeName employee name
     * @param employeeId employee id
     * @param payRate pay rate
     * @param ytdEarnings ytd earnings
     * @param ytdTaxesPaid ytd taxes paid
     * @param pretaxDeductions pretax deductions
     */
    public AbstractEmployee(TypeOfEmployee employeeType,String employeeName,String employeeId,double payRate
                        ,double ytdEarnings,double ytdTaxesPaid,double pretaxDeductions) {

        // check String inputs.
        checkStringValue(employeeName, "Employee name");
        checkStringValue(employeeId, "Employee id");
        // check double inputs.
        checkValue(payRate, "Pay rate");
        checkValue(ytdEarnings, "YTD earnings");
        checkValue(ytdTaxesPaid, "YTD taxes paid");
        checkValue(pretaxDeductions, "Pretax deductions");

        this.employeeType = employeeType;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
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
     * Check if the arguments' value are positve numbers.
     * @param val input value
     * @param var variable name
     * @throws IllegalArgumentException
     */
    public void checkValue(double val, String var) {
        if (val < 0) {
            String errorMsg = String.format("%s cannot be a negative number.", var);
            throw new IllegalArgumentException(errorMsg);
        }
    };

    /**
     * Gets the employee's name.
     * @return the name of the employee
     */
    public String getName() {
        return this.employeeName;
    };

    /**
     * Gets the employee's ID.
     * @return the ID of the employee
     */
    public String getID() {
        return this.employeeId;
    };

    /**
     * Gets the employee's pay rate.
     * @return the pay rate of the employee
     */
    public double getPayRate() {
        return this.payRate;
    };


    /**
     * Gets the employee's Type as a string.
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     * You may want to consider using an enum to store
     * the type, and using .name() to get the string representation.
     * @return the type of the employee as a string
     */
    public String getEmployeeType() {
        return this.employeeType.name();
    };

    /**
     * Gets the YTD earnings of the employee.
     * @return the YTD earnings of the employee
     */
    public double getYTDEarnings() {
        return this.ytdEarnings;
    };

    /**
     * Gets the YTD taxes paid by the employee.
     * @return the YTD taxes paid by the employee
     */
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    };

    /**
     * Gets pretax deductions for the employee. Yes, on a normal paycheck this varies as either set
     * amounts or percents, and often more than one type of deduction.
     * For now, you can just assume a single pretax deduction as a whole dollar amount.
     * @return the pretax deductions for the employee
     */
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    };

    /**
     * 
     * @param hoursWorked hours worked
     * @return the gross pay of a employee
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    /**
     * 
     * @param val the double number that needs to be rounded to two decimal places.
     * @return rounded double number
     */
    public double roundValue (double val) {
        BigDecimal bd = new BigDecimal(val).setScale(2, RoundingMode.HALF_UP);
        val = bd.doubleValue();
        return val;
    }

    /**
     * Runs the employee's payroll.
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for
     * withholding. or 22.65% total. They are calculated on the net pay (after pretax deductions).
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours,
     * then payRate * 1.5 * (hoursWorked - 40) for overtime.
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * If either type of employee has < 0 hours, they are skipped this payroll period. 
     * (suggestion return null, and skip adding nulls to your paystub list)
     * Final net pay is calculated as pay - pretaxDeductions - taxes.
     * All numbers (across all methods) are rounded to the nearest cent. (2 decimal places)
     * SUGGESTION: You may want to use BigDecimal for the calculations to avoid floating point errors.
     * SUGGESTION: You may want to create an protected abstract calculateGrossPay(double hoursWorked) 
     * method to calculate the gross pay for the pay period, as runPayroll is exactly
     * the same for both SalaryEmployee and HourlyEmployee, but calculateGrossPay is different.
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    public IPayStub runPayroll(double hoursWorked) {

        if (hoursWorked < 0) {
            return null;
        }

        double grossPay = this.calculateGrossPay(hoursWorked);

        double totalPercentage = 0.2265;
        double taxes = (grossPay - this.pretaxDeductions) * totalPercentage;
        taxes = roundValue(taxes);     

        double netPay = grossPay - this.pretaxDeductions - taxes;
        netPay = roundValue(netPay);    

        this.ytdEarnings = roundValue(this.ytdEarnings + netPay);    
        this.ytdTaxesPaid = roundValue(this.ytdTaxesPaid + taxes);  

        PayStub PayStub = new PayStub(this, netPay, taxes);
        return PayStub;
    };

    /**
     * Converts the employee to a CSV string.
     * Format of the String s as follows:
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     * employee_type has the options for HOURLY or SALARY.
     * You do not have to worry about commas in the name or any other field.
     * @return the employee as a CSV string
     */
    public String toCSV() {
        String csvString;
        csvString = String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f"
                                , this.employeeType, this.employeeName
                                , this.employeeId, this.payRate
                                , this.pretaxDeductions, this.ytdEarnings, this.ytdTaxesPaid);
        return csvString;
    };    
    

}
