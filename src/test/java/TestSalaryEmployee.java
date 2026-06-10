import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import student.SalaryEmployee;
import student.IPayStub;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSalaryEmployee{
    private SalaryEmployee emp;

    @BeforeEach
    public void setUp(){
        // Nami: payRate=200000, ytdEarnings=17017, ytdTaxesPaid=4983, pretaxDeductions=1000
        emp = new SalaryEmployee("Nami", "s193", 200000.0, 17017.0, 4983.0, 1000.0);
    }

    @Test
    public void testGetName(){
        assertEquals("Nami", emp.getName());
    }

    @Test
    public void testGetEmployeeType(){
        assertEquals("SALARY", emp.getEmployeeType());
    }

    /*
     *200000/24=8333.33
     * 8333，33-1000=7333.33
     * 7333.33*0.2265=1661
     * 7333.33-1661=5672.33
     */
    @Test
    public void testRunPayroll(){
        IPayStub stub = emp.runPayroll(60.0);
        assertNotNull(stub);
        assertEquals(5672.33, stub.getPay(), 0.01);
        assertEquals(1661.00, stub.getTaxesPaid(), 0.01);
        assertEquals(22689.33, emp.getYTDEarnings(), 0.01);
        assertEquals(6644.00, emp.getYTDTaxesPaid(), 0.01);
    }

    @Test
    public void testRunPayrollNegativeHours(){
        IPayStub stub = emp.runPayroll(-1.0);
        assertNull(stub);
    }
}
