import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class) // تفعيل Mockito
public class BankServiceTest {

    @Mock
    private TransactionLogger mockLogger; // Mocking external dependency

    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankService(mockLogger);
    }

    @Test
    @DisplayName("Should successfully transfer funds and log the transaction")
    void testSuccessfulTransfer() {
        // Arrange
        BankAccount acc1 = new BankAccount("A1", 500.0);
        BankAccount acc2 = new BankAccount("A2", 100.0);

        // Act
        bankService.transfer(acc1, acc2, 200.0);

        // Assert
        assertEquals(300.0, acc1.getBalance());
        assertEquals(300.0, acc2.getBalance());

        // Verify that the logger was called exactly once with a specific string pattern
        verify(mockLogger, times(1)).logTransaction(anyString());
    }
}