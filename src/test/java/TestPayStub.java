

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
        TestHourlyEmployee = new HourlyEmployee("Luffy", "s192"
                                                , 30.00, 20000.00
                                                , 4530.00, 0.00);
        TestSalaryEmployee = new SalaryEmployee("Nami", "s193"
                                                , 200000.00, 17017.00
                                                , 4983.00, 1000.00);  
        TestHourlyPayStub = new PayStub(TestHourlyEmployee, 1102.24, 322.76);
        TestSalaryPayStub = new PayStub(TestSalaryEmployee, 5672.33, 1661.00);  
    }

    /**
     * Tests to make sure the net pay is being returned properly.
     */
    @Test
    public void testGetPay() {
        assertEquals(1102.24, TestHourlyPayStub.getPay());
        assertEquals(5672.33, TestSalaryPayStub.getPay());
    }  

    /**
     * Tests to make sure the taxes paid is being returned properly.
     */
    @Test
    public void testGetTaxesPaid() {
        assertEquals(322.76, TestHourlyPayStub.getTaxesPaid());
        assertEquals(1661.0, TestSalaryPayStub.getTaxesPaid());
    }         

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testToCSV() {
        assertEquals("Luffy,1102.24,322.76,20000.00,4530.00", TestHourlyPayStub.toCSV());
        assertEquals("Nami,5672.33,1661.00,17017.00,4983.00", TestSalaryPayStub.toCSV());
    }        
}
