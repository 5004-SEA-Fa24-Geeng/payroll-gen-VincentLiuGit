package student;


/**
 * Remind user that the length of csv String line should be the same number as the column number.
 */

class IllegalLengthException extends Exception {
    IllegalLengthException(String errorMessage) {
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
     * @return double value 
     * @throws IllegalArgumentException
     */
    public static double checkValue(String val, String var) {
        try {
            double returnVal = Double.parseDouble(val);
            return returnVal;
        } catch (NumberFormatException e) {
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
    public static IEmployee buildEmployeeFromCSV(String csv) {

        IEmployee employee = null;        
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

        String stringeType = parts[0];
        String stringName = parts[1];
        String stringId = parts[2];
        String stringPayRate = parts[3];        
        String stringPretaxDeductions = parts[4];
        String stringYTDEarnings = parts[5];
        String stringYTDTaxesPaid = parts[6];

        double payRate = checkValue(stringPayRate, "payRate");
        double pretaxDeductions = checkValue(stringPretaxDeductions, "pretaxDeductions");
        double YTDEarnings = checkValue(stringYTDEarnings, "YTDEarnings");
        double YTDTaxesPaid = checkValue(stringYTDTaxesPaid, "YTDTaxesPaid");

        if (stringeType.equals("HOURLY")) {
            employee = new HourlyEmployee(stringName,stringId
                                        ,payRate,YTDEarnings,YTDTaxesPaid,pretaxDeductions);
        } else if (stringeType.equals("SALARY")) {
            employee = new SalaryEmployee(stringName,stringId
                                        ,payRate,YTDEarnings,YTDTaxesPaid,pretaxDeductions);
        }

        return employee;
    }


   /**
     * Converts a TimeCard from a CSV String.
     * @param csv csv string
     * @return a TimeCard object
     * @throws IllegalLengthException,NumberFormatException
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {

        ITimeCard timeCard = null;        
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

        String stringeId = parts[0];
        String stringHoursWorked = parts[1];   

        double hoursWorked = 0;
        try {
            hoursWorked = Double.parseDouble(stringHoursWorked);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("hoursWorked cannot be String.");            
        }
        
        timeCard = new TimeCard(stringeId, hoursWorked);
    
        return timeCard;
    }
}
