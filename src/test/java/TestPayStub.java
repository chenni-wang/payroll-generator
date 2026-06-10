import student.PayStub;
import student.IPayStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
*JUnit test class for PayStub
 */

public class TestPayStub {

    private PayStub stub;

    @BeforeEach
    public void setUp(){
        stub = new PayStub("Luffy", 1800.0, 500.0, 21800.0, 5030.0);
    }

    @Test
    public void testGetPay(){
        assertEquals(1800.0, stub.getPay(), 0.01);
    }

    @Test
    public void testGetTaxesPaid(){
        assertEquals(500.0, stub.getTaxesPaid(), 0.01);
    }

    @Test
    public void testToCSV(){
        assertEquals("Luffy,1800.0,500.0,21800.0,5030.0", stub.toCSV());
    }
}
