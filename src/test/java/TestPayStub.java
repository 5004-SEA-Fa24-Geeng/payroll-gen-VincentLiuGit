

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.HourlyEmployee;
import student.PayStub;
import student.SalaryEmployee;



public class TestPayStub {


    private HourlyEmployee TestHourlyEmployee;
    private SalaryEmployee TestSalaryEmployee;
    private PayStub TestHourlyPayStub;
    private PayStub TestSalaryPayStub;

    /**
     * Executed before every tests, resets the values of the HourlyEmployee, SalaryEmployee and PayStub objects.
     */
    @BeforeEach
    public void setUp() {
        TestHourlyEmployee = new HourlyEmployee("HOURLY", "Luffy"
                                            , "s192", 30.00, 20000.00, 4530.00, 0.00);
        TestSalaryEmployee = new SalaryEmployee("SALARY", "Nami"
                                            , "s193", 200000.00, 17017.00, 4983.00, 1000.00);  
        TestHourlyPayStub = new PayStub(TestHourlyEmployee, 928.2, 271.8, 20928.20, 4801.80);
        TestSalaryPayStub = new PayStub(TestSalaryEmployee, 12118.17, 3548.50, 29135.17, 8531.50);  
    }

    /**
     * Tests to make sure the net pay is being returned properly.
     */
    @Test
    public void testGetPay() {
        assertEquals(928.2, TestHourlyPayStub.getPay());
        assertEquals(12118.17, TestSalaryPayStub.getPay());
    }  

    /**
     * Tests to make sure the taxes paid is being returned properly.
     */
    @Test
    public void testGetTaxesPaid() {
        assertEquals(271.8, TestHourlyPayStub.getTaxesPaid());
        assertEquals(3548.50, TestSalaryPayStub.getTaxesPaid());
    }   

    /**
     * Tests to make sure the new ytd earnings is being returned properly.
     */
    @Test
    public void testGetNewYtdEarnings() {
        assertEquals(20928.20, TestHourlyPayStub.getNewYtdEarnings());
        assertEquals(29135.17, TestSalaryPayStub.getNewYtdEarnings());
    }       
    
    /**
     * Tests to make sure the new ytd taxes paid is being returned properly.
     */
    @Test
    public void testGetNewYtdTaxesPaid() {
        assertEquals(4801.80, TestHourlyPayStub.getNewYtdTaxesPaid());
        assertEquals(8531.50, TestSalaryPayStub.getNewYtdTaxesPaid());
    }        

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testToCSV() {
        assertEquals("Luffy,928.20,271.80,20928.20,4801.80", TestHourlyPayStub.toCSV());
        assertEquals("Nami,12118.17,3548.50,29135.17,8531.50", TestSalaryPayStub.toCSV());
    }        
}
