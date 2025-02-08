

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.TimeCard;


public class TestTimeCard {

    private TimeCard TestTimeCard;

    /**
     * Executed before every tests, resets the values of the Greeting objects.
     */
    @BeforeEach
    public void setUp() {
        TestTimeCard = new TimeCard("s192",45);       
    }

    /**
     * Tests to make sure the pay for the current pay period is being returned properly.
     */
    @Test
    public void testGetEmployeeID() {
        assertEquals("s192", TestTimeCard.getEmployeeID());
    }

    /**
     * Tests to make sure the taxes paid for the current pay period is being returned properly.
     */
    @Test
    public void testGetHoursWorked() {
        assertEquals(45, TestTimeCard.getHoursWorked());
    }    

}
