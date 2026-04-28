import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    @Test
    void testTransfer() {
        BankAccount acc1 = new BankAccount(2110);
        BankAccount acc2 = new BankAccount(100);

        BankService service = new BankService();
        service.transfer(acc1, acc2, 50);

        assertEquals(150, acc1.getBalance());
        assertEquals(150, acc2.getBalance());
    }
}