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
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return Employee the employee object
     * @throws IllegalLengthException 
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

        double payRate = 0;
        try {
            payRate = Double.parseDouble(StringPayRate);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("payRate cannot be String.");
        }

        double pretaxDeductions = 0;
        try {
            pretaxDeductions = Double.parseDouble(StringPretaxDeductions);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("pretaxDeductions cannot be String.");            
        }

        double YTDEarnings = 0;
        try {
            YTDEarnings = Double.parseDouble(StringYTDEarnings);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("YTDEarnings cannot be String.");            
        }

        double YTDTaxesPaid = 0;
        try {
            YTDTaxesPaid = Double.parseDouble(StringYTDTaxesPaid);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("YTDTaxesPaid cannot be String.");            
        }

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
     * 
     * @param csv csv string
     * @return a TimeCard object
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
