package student;


public class PayStub implements IPayStub {

    private IEmployee employee;
    private double netPay;
    private double taxes;
    private double newYtdEarnings;
    private double newYtdTaxesPaid;


    public PayStub(IEmployee employee, double netPay, double taxes
                    , double newYtdEarnings, double newYtdTaxesPaid) {
        this.employee = employee;
        this.netPay = netPay;        
        this.taxes = taxes;
        this.newYtdEarnings = newYtdEarnings;        
        this.newYtdTaxesPaid = newYtdTaxesPaid;
    }

    /**
     * Gets the pay for the current pay period.
     * 
     * @return the pay for the current pay period
     */    
    public double getPay() {
        return this.netPay;
    }

    /**
     * Gets the taxes paid for the current pay period.
     * 
     * @return the taxes paid for the current pay period
     */    
    public double getTaxesPaid() {  
        return this.taxes;
    }

    /**
     * Gets the new YtdEarnings.
     * 
     * @return the new YtdEarnings
     */    
    public double getNewYtdEarnings() {  
        return this.newYtdEarnings;
    }

    /**
     * Gets the new YtdTaxesPaid.
     * 
     * @return the new YtdTaxesPaid
     */    
    public double getNewYtdTaxesPaid() {  
        return this.newYtdTaxesPaid;
    }

    /**
     * Converts the PayStub object to a CSV string.
     * 
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     * 
     * @return the CSV string
     */    
    public String toCSV() {
        String csvString;
        csvString = String.format("%s,%.2f,%.2f,%.2f,%.2f"
                                , this.employee.getName(), this.netPay
                                , this.taxes, this.newYtdEarnings, this.newYtdTaxesPaid);
        return csvString;
    }
}
