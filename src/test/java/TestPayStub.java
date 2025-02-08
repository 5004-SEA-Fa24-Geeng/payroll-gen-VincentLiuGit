

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import student.PayStub;



// public class TestPayStub {

//     private PayStub TestHourlyPayStub;
//     private PayStub TestSalaryPayStub;

//     /**
//      * Executed before every tests, resets the values of the PayStub objects.
//      */
//     @BeforeEach
//     public void setUp() {
//         TestHourlyPayStub = new PayStub("Luffy", 2000, 0, 20000, 4530);
//         TestSalaryPayStub = new PayStub("Nami", 5000, 1000, 17017, 4983);  
//     }

//     /**
//      * Tests to make sure the pay for the current pay period is being returned properly.
//      */
//     @Test
//     public void testGetPay() {
//         assertEquals(2000, TestHourlyPayStub.getPay());
//         assertEquals(5000, TestSalaryPayStub.getPay());
//     }  

//     /**
//      * Tests to make sure the taxes paid for the current pay period is being returned properly.
//      */
//     @Test
//     public void testGetTaxesPaid() {
//         assertEquals(453, TestHourlyPayStub.getTaxesPaid());
//         assertEquals(906, TestSalaryPayStub.getTaxesPaid());
//     }   

//     /**
//      * Tests to make sure the pay for the current pay period is being returned properly.
//      */
//     @Test
//     public void testGetNetPay() {
//         assertEquals(1547.0, TestHourlyPayStub.getNetPay());
//         assertEquals(3094.0, TestSalaryPayStub.getNetPay());
//     }      

//     /**
//      * Tests to make sure the pay for the current pay period is being returned properly.
//      */
//     @Test
//     public void testGetRoundedYTDEarnings() {
//         assertEquals(21547.0, TestHourlyPayStub.getRoundedYTDEarnings(20000));
//         assertEquals(20111.0, TestSalaryPayStub.getRoundedYTDEarnings(17017));
//     }       
    
//     /**
//      * Tests to make sure the pay for the current pay period is being returned properly.
//      */
//     @Test
//     public void testGetRoundedYTDTaxesPaid() {
//         assertEquals(4983.0, TestHourlyPayStub.getRoundedYTDTaxesPaid(4530));
//         assertEquals(5889.0, TestSalaryPayStub.getRoundedYTDTaxesPaid(4983));
//     }        

//     /**
//      * Tests to make sure the CSV string is being returned properly.
//      * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
//      */
//     @Test
//     public void testToCSV() {
//         assertEquals("Luffy,1547.00,453.00,21547.00,4983.00", TestHourlyPayStub.toCSV());
//         assertEquals("Nami,3094.00,906.00,20111.00,5889.00", TestSalaryPayStub.toCSV());
//     }        
// }
