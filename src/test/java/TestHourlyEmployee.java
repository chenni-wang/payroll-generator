import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import student.HourlyEmployee;
import student.IPayStub;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class TestHourlyEmployee {

    private HourlyEmployee emp;
    private HourlyEmployee emp2;

    @BeforeEach
    public void setUp(){
        emp = new HourlyEmployee("Luffy", "s192", 30, 20000, 4530, 0);
        emp2 = new HourlyEmployee("Light Yagami",	"x101",25,10000,2265,0);
    }

    @Test
    public void testGetName(){
        assertEquals("Luffy", emp.getName());
    }

    @Test
    public void testGetID(){
        assertEquals("s192", emp.getID());
    }

    @Test
    public void testGetPayRate(){
        assertEquals(30, emp.getPayRate(), 0.01);
    }

    @Test
    public void testGetEmployeeType(){
        assertEquals("HOURLY", emp.getEmployeeType());
    }

    @Test
    public void testGetPretaxDeductions(){
        assertEquals(0, emp.getPretaxDeductions(), 0.01);
    }

    /*
    * light yagami less than 40hours:
    * 25*40=1000
    * 1000*0.2265=226.5
    * 1000-226.5=773.5
     */
    @Test
    public void testRunPayroll40(){
        IPayStub stub = emp2.runPayroll(40);
        assertNotNull(stub);
        assertEquals(773.5, stub.getPay(),0.01);
        assertEquals(226.5, stub.getTaxesPaid(), 0.01);
        assertEquals(10773.5, emp2.getYTDEarnings(),0.01);
        assertEquals(2491.5, emp2.getYTDTaxesPaid(),0.01);
    }

    /*
    *luffy 30*40+30*1.5*5=1425
    * 1425*0.2265=322.76
    * 1425-322.76=1102.24
     */
    @Test
    public void testRunPayrollOvertime(){
        IPayStub stub = emp.runPayroll(45.0);
        assertNotNull(stub);
        assertEquals(1102.24, stub.getPay(), 0.01);
        assertEquals(322.76, stub.getTaxesPaid(), 0.01);
    }

    @Test
    public void testRunPayrollNegativeHours(){
        IPayStub stub = emp.runPayroll(-1.0);
        assertNull(stub);
    }

    @Test
    public void testRunPayrollZeroHours(){
        IPayStub stub = emp.runPayroll(0.0);
        assertNotNull(stub);
        assertEquals(0.0, stub.getPay(), 0.01);
    }

    }

