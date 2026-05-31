import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACC-123", 1000.0);
    }

    @Test
    @DisplayName("Should successfully deposit a valid amount")
    void testSuccessfulDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Balance should increase by deposit amount");
    }

    @Test
    @DisplayName("Should successfully withdraw a valid amount")
    void testSuccessfulWithdrawal() {
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance(), "Balance should decrease by withdrawal amount");
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -50.0, -1.0})
    @DisplayName("Should throw exception for invalid withdrawal amounts")
    void testInvalidWithdrawalAmounts(double invalidAmount) {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> account.withdraw(invalidAmount)
        );
        assertEquals("Withdrawal amount must be greater than 0", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when withdrawing more than balance")
    void testInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(2000.0));
    }
}