import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testWithdraw() {
        BankAccount acc = new BankAccount(100);
        acc.withdraw(250);
        assertTrue(acc.getBalance() >= 0); 
    }
}