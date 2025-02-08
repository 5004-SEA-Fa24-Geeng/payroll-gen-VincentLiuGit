
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
     * Executed before every tests, resets the values of the HourlyEmployee and SalaryEmployee objects.
     */
    @BeforeEach
    public void setUp() {
        Employee = Builder.buildEmployeeFromCSV("HOURLY,Luffy,s192,30.00,0,20000,4530");
        TimeCard = Builder.buildTimeCardFromCSV("s192,45");
    }

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testGetEmployeeType() {
        assertEquals("HOURLY", Employee.getEmployeeType());
    }  

    /**
     * Tests to make sure the employee name is being returned properly.
     */
    @Test
    public void testGetName() {
        assertEquals("Luffy", Employee.getName());
    }

    /**
     * Tests to make sure the employee id is being returned properly.
     */
    @Test
    public void testGetID() {
        assertEquals("s192", Employee.getID());
    }    

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testGetPayRate() {
        assertEquals(30.00, Employee.getPayRate());
    }            
    
    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testGetYTDEarnings() {
        assertEquals(20000.00, Employee.getYTDEarnings());
    }   

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testGetYTDTaxesPaid() {
        assertEquals(4530.00, Employee.getYTDTaxesPaid());
    }   

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testRunPayroll() {
        double hoursWorked = TimeCard.getHoursWorked();
        assertNotNull(Employee.runPayroll(hoursWorked));
    }   

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testToCSV() {
        assertEquals("HOURLY,Luffy,s192,30.00,0.00,20000.00,4530.00", Employee.toCSV());
    }   

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testGetEmployeeID() {
        assertEquals("s192", TimeCard.getEmployeeID());
    }   

    /**
     * Tests to make sure the CSV string is being returned properly.
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     */
    @Test
    public void testGetHoursWorked() {
        assertEquals("45", TimeCard.getHoursWorked());
    }   



}

