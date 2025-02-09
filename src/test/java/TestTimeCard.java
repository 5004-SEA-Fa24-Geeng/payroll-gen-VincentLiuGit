

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.TimeCard;


public class TestTimeCard {

    private TimeCard TestTimeCard;

    /**
     * Executed before every tests, resets the values of the TimeCard objects.
     */
    @BeforeEach
    public void setUp() {
        TestTimeCard = new TimeCard("s192",45);       
    }

    /**
     * Tests to make sure the string input is not null.
     */
    @Test
    public void testCheckStringValueException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeCard(null,45);
        });
        assertEquals("Employee id cannot be null.", exception.getMessage());
    }

    /**
     * Tests to make sure the double input is a postive number.
     */
    @Test
    public void testCheckValueException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeCard("s192",-45);
        });
        assertEquals("Hours worked cannot be a negative number.", exception.getMessage());
    }
    /**
     * Tests to make sure the employee id is being returned properly.
     */
    @Test
    public void testGetEmployeeID() {
        assertEquals("s192", TestTimeCard.getEmployeeID());
    }

    /**
     * Tests to make sure the hours worked is being returned properly.
     */
    @Test
    public void testGetHoursWorked() {
        assertEquals(45, TestTimeCard.getHoursWorked());
    }    

}
