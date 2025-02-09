
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.HourlyEmployee;
import student.IPayStub;
import student.SalaryEmployee;



public class TestEmployee {

    private HourlyEmployee TestHourlyEmployee;
    private SalaryEmployee TestSalaryEmployee;

    /**
     * Executed before every tests, resets the values of the HourlyEmployee and SalaryEmployee objects.
     */
    @BeforeEach
    public void setUp() {
        TestHourlyEmployee = new HourlyEmployee("Luffy", "s192"
                                                , 30.00, 20000.00
                                                , 4530.00, 0.00);
        TestSalaryEmployee = new SalaryEmployee("Nami", "s193"
                                                , 200000.00, 17017.00
                                                , 4983.00, 1000.00);  
    }

    /**
     * Tests to make sure the employee name is being returned properly.
     */
    @Test
    public void testGetName() {
        assertEquals("Luffy", TestHourlyEmployee.getName());
        assertEquals("Nami", TestSalaryEmployee.getName());
    }

    /**
     * Tests to make sure the employee id is being returned properly.
     */
    @Test
    public void testGetID() {
        assertEquals("s192", TestHourlyEmployee.getID());
        assertEquals("s193", TestSalaryEmployee.getID());
    }    

    /**
     * Tests to make sure the pay rate is being returned properly.
     */
    @Test
    public void testGetPayRate() {
        assertEquals(30.00, TestHourlyEmployee.getPayRate());
        assertEquals(200000.00, TestSalaryEmployee.getPayRate());
    }       

    /**
     * Tests to make sure the employee type is being returned properly.
     */
    @Test
    public void testGetEmployeeType() {
        assertEquals("HOURLY", TestHourlyEmployee.getEmployeeType());
        assertEquals("SALARY", TestSalaryEmployee.getEmployeeType());
    }       

    /**
     * Tests to make sure the ytd earnings is being returned properly.
     */
    @Test
    public void testGetYTDEarnings() {
        assertEquals(20000.00, TestHourlyEmployee.getYTDEarnings());
        assertEquals(17017.00, TestSalaryEmployee.getYTDEarnings());
    }   

    /**
     * Tests to make sure the ytd taxes paid is being returned properly.
     */
    @Test
    public void testGetYTDTaxesPaid() {
        assertEquals(4530.00, TestHourlyEmployee.getYTDTaxesPaid());
        assertEquals(4983.00, TestSalaryEmployee.getYTDTaxesPaid());
    }   

    /**
     * Tests to make sure the pretax Deductions is being returned properly.
     */
    @Test
    public void testGetPretaxDeductions() {
        assertEquals(0.00, TestHourlyEmployee.getPretaxDeductions());
        assertEquals(1000.00, TestSalaryEmployee.getPretaxDeductions());
    }   

    /**
     * Tests to make sure the number is being rounded properly.
     */
    @Test
    public void testRoundValue() {
        assertEquals(100.53, TestHourlyEmployee.roundValue(100.525));
    }  

    /**
     * Tests to make sure the pay roll is not null when hoursWorked >= 0.
     * Tests to make sure the pay roll is null when hoursWorked < 0.
     * Tests to make sure the methods in the pay roll of hourly employee and salary employee are performed properly.
     */
    @Test
    public void testRunPayroll() {
        
        // Test hoursWorked < 0
        assertNull(TestHourlyEmployee.runPayroll(-1));
        assertNull(TestSalaryEmployee.runPayroll(-1));

        // Test hoursWorked >= 0
        assertNotNull(TestHourlyEmployee.runPayroll(0));
        assertNotNull(TestSalaryEmployee.runPayroll(50));

        // Test PayStub
        IPayStub TestHourlyEmployeePayStub = TestHourlyEmployee.runPayroll(40);
        assertEquals(928.2, TestHourlyEmployeePayStub.getPay());
        assertEquals(271.8, TestHourlyEmployeePayStub.getTaxesPaid());
        assertEquals("Luffy,928.20,271.80,20928.20,4801.80", TestHourlyEmployeePayStub.toCSV());

        IPayStub TestSalaryEmployeePayStub = TestSalaryEmployee.runPayroll(1);
        assertEquals(5672.33, TestSalaryEmployeePayStub.getPay());        
        assertEquals(1661.0, TestSalaryEmployeePayStub.getTaxesPaid());     
        assertEquals("Nami,5672.33,1661.00,22689.33,6644.00", TestSalaryEmployeePayStub.toCSV());     
    }   

    /**
     * Tests to make sure the gross pay is being returned properly.
     */
    @Test
    public void testCalculateGrossPay() {
        assertEquals(1200.00, TestHourlyEmployee.calculateGrossPay(40));
        assertEquals(0.00, TestHourlyEmployee.calculateGrossPay(-1));        
        assertEquals(8333.33, TestSalaryEmployee.calculateGrossPay(1));        
    }   

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid"
     */
    @Test
    public void testToCSV() {
        assertEquals("HOURLY,Luffy,s192,30.00,0.00,20000.00,4530.00", TestHourlyEmployee.toCSV());      
        assertEquals("SALARY,Nami,s193,200000.00,1000.00,17017.00,4983.00", TestSalaryEmployee.toCSV());        
    }   



}

