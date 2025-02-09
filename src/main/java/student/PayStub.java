package student;


public class PayStub implements IPayStub {
    /**
     * employee.
     */
    private IEmployee employee;
    /**
     * netPay.
     */
    private double netPay;
    /**
     * taxes.
     */
    private double taxes;


    /**
     * create a PayStub object.
     * @param employee employee object
     * @param netPay net pay = grossPay - pretax_deductions - taxes
     * @param taxes taxes = (grossPay - pretax_deductions) * totalPercentage
     */
    public PayStub(IEmployee employee, double netPay, double taxes) {
        this.employee = employee;
        this.netPay = netPay;        
        this.taxes = taxes;
    }

    /**
     * Gets the pay for the current pay period.
     * @return the pay for the current pay period
     */    
    public double getPay() {
        return this.netPay;
    }

    /**
     * Gets the taxes paid for the current pay period.
     * @return the taxes paid for the current pay period
     */    
    public double getTaxesPaid() {  
        return this.taxes;
    }

    /**
     * Converts the PayStub object to a CSV string.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     * @return the CSV string
     */    
    public String toCSV() {
        String csvString;
        csvString = String.format("%s,%.2f,%.2f,%.2f,%.2f", this.employee.getName(), this.netPay, this.taxes, this.employee.getYTDEarnings(), this.employee.getYTDTaxesPaid());
        return csvString;
    }
}
