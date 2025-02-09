package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HourlyEmployee extends AbstractEmployee {

    /**
     * create a HourlyEmployee object.
     * @param employeeName employeeName
     * @param employeeId employeeId
     * @param payRate payRate
     * @param ytdEarnings ytdEarnings
     * @param ytdTaxesPaid ytdTaxesPaid
     * @param pretaxDeductions pretaxDeductions
     */
    public HourlyEmployee(String employeeName, String employeeId, 
                        double payRate, double ytdEarnings, double ytdTaxesPaid, 
                        double pretaxDeductions) {
        super(TypeOfEmployee.HOURLY, employeeName, employeeId, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public double calculateGrossPay(double hoursWorked) {
        double grossPay = 0;
        if (hoursWorked > 0 && hoursWorked <= 40) {
            grossPay = getPayRate() * hoursWorked;
        } else if (hoursWorked > 40) {
            grossPay = getPayRate() * 40 + getPayRate() * 1.5 * (hoursWorked - 40);
        }
        BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
        double rounded = bd.doubleValue();
        return rounded;
    };

}
