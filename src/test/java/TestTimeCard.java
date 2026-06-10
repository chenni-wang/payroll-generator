
import student.TimeCard;
import student.ITimeCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



/*
* JUnit test class for TimeCard
 */
public class TestTimeCard {

    private TimeCard tc;

    @BeforeEach
    public void setUp(){
        tc = new TimeCard("s192",40);
    }

    @Test
    public void testGetEmployeeID(){
        assertEquals("s192", tc.getEmployeeID());
    }

    @Test
    public void testGetHoursWorked(){
        assertEquals(40, tc.getHoursWorked(), 0.01);
    }

}
