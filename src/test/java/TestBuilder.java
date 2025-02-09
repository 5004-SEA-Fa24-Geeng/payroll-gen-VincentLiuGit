
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.Builder;
import student.IEmployee;
import student.ITimeCard;



public class TestBuilder {

    private IEmployee Employee;
    private ITimeCard TimeCard;


    /**
     * Executed before every tests, resets the values of the Builder objects.
     */
    @BeforeEach
    public void setUp() {
        Employee = Builder.buildEmployeeFromCSV("HOURLY,Luffy,s192,30.00,0,20000,4530");
        TimeCard = Builder.buildTimeCardFromCSV("s192,45");
    }

    /**
     * Tests to make sure the employee type in Employee is being returned properly.
     */
    @Test
    public void testGetEmployeeType() {
        assertEquals("HOURLY", Employee.getEmployeeType());
    }  

    /**
     * Tests to make sure the employee name in Employee is being returned properly.
     */
    @Test
    public void testGetName() {
        assertEquals("Luffy", Employee.getName());
    }

    /**
     * Tests to make sure the employee id in Employee is being returned properly.
     */
    @Test
    public void testGetID() {
        assertEquals("s192", Employee.getID());
    }    

    /**
     * Tests to make sure the pay rate in Employee is being returned properly.
     */
    @Test
    public void testGetPayRate() {
        assertEquals(30.00, Employee.getPayRate());
    }            
    
    /**
     * Tests to make sure the ytd earnings in Employee is being returned properly.
     */
    @Test
    public void testGetYTDEarnings() {
        assertEquals(20000.00, Employee.getYTDEarnings());
    }   

    /**
     * Tests to make sure the ytd taxes paid in Employee is being returned properly.
     */
    @Test
    public void testGetYTDTaxesPaid() {
        assertEquals(4530.00, Employee.getYTDTaxesPaid());
    }   

    /**
     * Tests to make sure the pretax Deductions is being returned properly.
     */
    @Test
    public void testGetPretaxDeductions() {
        assertEquals(0.00, Employee.getPretaxDeductions());
    }   

    /**
     * Tests to make sure the pay roll in Employee is not null.
     */
    @Test
    public void testRunPayroll() {
        double hoursWorked = TimeCard.getHoursWorked();
        assertNotNull(Employee.runPayroll(hoursWorked));
    }   

    /**
     * Tests to make sure the CSV string in Employee is being returned properly.
     * Format of the CSV string is: "employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid"
     */
    @Test
    public void testToCSV() {
        assertEquals("HOURLY,Luffy,s192,30.00,0.00,20000.00,4530.00", Employee.toCSV());
    }   

    /**
     * Tests to make sure the employee id in TimeCard is being returned properly.
     */
    @Test
    public void testGetEmployeeID() {
        assertEquals("s192", TimeCard.getEmployeeID());
    }   

    /**
     * Tests to make sure the hours worked in TimeCard is being returned properly.
     */
    @Test
    public void testGetHoursWorked() {
        assertEquals(45.0, TimeCard.getHoursWorked());
    }   



}

