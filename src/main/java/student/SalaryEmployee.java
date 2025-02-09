package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends AbstractEmployee{

    public SalaryEmployee(String employeeName, String employeeId, double payRate
                        , double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(TypeOfEmployee.SALARY,employeeName,employeeId,payRate,ytdEarnings,ytdTaxesPaid,pretaxDeductions);
    }


    @Override
    public double calculateGrossPay(double hoursWorked) {
        double rounded = 0;
        if (hoursWorked >= 0) {
            double grossPay = 0;
            grossPay = getPayRate() / 24;
            BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
            rounded = bd.doubleValue();
        }
        return rounded;
    };

}
