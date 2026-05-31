import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BankService {
    
    private final TransactionLogger logger;

    public void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
        
        String logMessage = String.format("Transferred %.2f from %s to %s", 
                                          amount, from.getAccountNumber(), to.getAccountNumber());
        logger.logTransaction(logMessage);
    }
}