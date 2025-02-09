package student;


/**
 * Remind user that the length of csv String line should be the same number as the column number.
 */

class IllegalLengthException extends Exception{
    public IllegalLengthException(String errorMessage){
        super(errorMessage);
    }
}

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }

    /**
     * Check if the arguments' value are positve numbers.
     * @param val input value
     * @param var variable name
     * @throws IllegalArgumentException
     */
    public static double checkValue(String val, String var) {
        try {
            double returnVal = Double.parseDouble(val);
            return returnVal;
        } catch(NumberFormatException e) {
            // handle the error
            String errorMsg = String.format("%s cannot be a negative number.", var);
            throw new NumberFormatException(errorMsg);
        }
    };

     /**
     * Builds an employee object from a CSV string.
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * @param csv the CSV string
     * @return Employee the employee object
     * @throws IllegalLengthException,NumberFormatException
     */
    public static IEmployee buildEmployeeFromCSV(String csv){

        IEmployee Employee = null;        
        int columnNum = 7;
        String[] parts = csv.split(",");

        try {
            if (parts.length != columnNum) {
                // thorw exception
                throw new IllegalLengthException("Line length should be column Num.");
            }
        } catch (IllegalLengthException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        String StringeType = parts[0];
        String StringName = parts[1];
        String StringId = parts[2];
        String StringPayRate = parts[3];        
        String StringPretaxDeductions = parts[4];
        String StringYTDEarnings = parts[5];
        String StringYTDTaxesPaid = parts[6];

        double payRate = checkValue(StringPayRate, "payRate");
        double pretaxDeductions = checkValue(StringPretaxDeductions, "pretaxDeductions");
        double YTDEarnings = checkValue(StringYTDEarnings, "YTDEarnings");
        double YTDTaxesPaid = checkValue(StringYTDTaxesPaid, "YTDTaxesPaid");

        if (StringeType.equals("HOURLY")) {
            Employee = new HourlyEmployee(StringeType, StringName, StringId
                                            , payRate, YTDEarnings, YTDTaxesPaid, pretaxDeductions);
        } else if (StringeType.equals("SALARY")) {
            Employee = new SalaryEmployee(StringeType, StringName, StringId
                                            , payRate, YTDEarnings, YTDTaxesPaid, pretaxDeductions);
        }

        return Employee;
    }


   /**
     * Converts a TimeCard from a CSV String.
     * @param csv csv string
     * @return a TimeCard object
     * @throws IllegalLengthException,NumberFormatException
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {

        ITimeCard TimeCard = null;        
        int columnNum = 2;
        String[] parts = csv.split(",");

        try {
            if (parts.length != columnNum) {
                // thorw exception
                throw new IllegalLengthException("Line length should be columnNum.");
            }
        } catch (IllegalLengthException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        String StringeId = parts[0];
        String StringHoursWorked = parts[1];   

        double hoursWorked = 0;
        try {
            hoursWorked = Double.parseDouble(StringHoursWorked);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("hoursWorked cannot be String.");            
        }
        
        TimeCard = new TimeCard(StringeId, hoursWorked);
    
        return TimeCard;
    }
}
