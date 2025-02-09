package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HourlyEmployee extends AbstractEmployee{

    public HourlyEmployee(String employee_type, String employee_name, String employee_id, double pay_rate
                        , double ytd_earnings, double ytd_taxes_paid, double pretax_deductions) {
        super(employee_type, employee_name, employee_id, pay_rate, ytd_earnings, ytd_taxes_paid, pretax_deductions);
    }

    @Override
    public double calculateGrossPay(double hoursWorked) {
        double grossPay = 0;
        if (hoursWorked > 0 && hoursWorked <= 40) {
            grossPay = this.pay_rate * hoursWorked;
        } else if (hoursWorked > 40) {
            grossPay = this.pay_rate * 40 + this.pay_rate * 1.5 * (hoursWorked-40);
        }
        BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
        double rounded = bd.doubleValue();
        return rounded;
    };

}
