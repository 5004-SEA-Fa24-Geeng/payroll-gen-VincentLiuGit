package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends AbstractEmployeePayroll{

    public SalaryEmployee(String employee_type, String employee_name, String employee_id, double pay_rate
                        , double ytd_earnings, double ytd_taxes_paid, double pretax_deductions) {
        super(employee_type, employee_name, employee_id, pay_rate, ytd_earnings, ytd_taxes_paid, pretax_deductions);
    }

    @Override
    public double calculateGrossPay(double hoursWorked) {
        double rounded = 0;
        if (hoursWorked > 0) {
            double grossPay = 0;
            grossPay = this.pay_rate / 24 * 2;
            BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
            rounded = bd.doubleValue();
        }
        return rounded;
    };

}
