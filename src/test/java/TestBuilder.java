import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import student.Builder;
import student.IEmployee;
import student.ITimeCard;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;



/*
*This is a JUnit test class for Builder
 */

public class TestBuilder {

    @Test
    public void testBuildHourlyEmployeeFromCSV() {
        IEmployee emp = Builder.buildEmployeeFromCSV("HOURLY,Luffy,s192,30,0,20000,4530");
        assertNotNull(emp);
        assertEquals("Luffy", emp.getName());
        assertEquals("s192", emp.getID());
        assertEquals(30.0, emp.getPayRate(), 0.01);
        assertEquals("HOURLY", emp.getEmployeeType());
        assertEquals(0, emp.getPretaxDeductions());
        assertEquals(20000.0, emp.getYTDEarnings(), 0.01);
        assertEquals(4530.0, emp.getYTDTaxesPaid(), 0.01);
    }

    @Test
    public void testBuildSalaryEmployeeFromCSV() {
        IEmployee emp = Builder.buildEmployeeFromCSV("SALARY,Nami,s193,200000,1000,17017,4983");
        assertNotNull(emp);
        assertEquals("Nami", emp.getName());
        assertEquals("s193", emp.getID());
        assertEquals(200000, emp.getPayRate(), 0.01);
        assertEquals("SALARY", emp.getEmployeeType());
        assertEquals(1000, emp.getPretaxDeductions());
        assertEquals(17017, emp.getYTDEarnings(), 0.01);
        assertEquals(4983, emp.getYTDTaxesPaid(), 0.01);
    }

    @Test
    public void testBuildTimeCardFromCSV() {
        ITimeCard tc = Builder.buildTimeCardFromCSV("s192,45");
        assertNotNull(tc);
        assertEquals("s192", tc.getEmployeeID());
        assertEquals(45, tc.getHoursWorked(), 0.01);
    }
}