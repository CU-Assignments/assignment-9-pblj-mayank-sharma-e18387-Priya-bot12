import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Override
    @Transactional
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accountDao.getAccount(fromAccountId);
        Account toAccount = accountDao.getAccount(toAccountId);

        if (fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);

            // Save transaction
            Transaction transaction = new Transaction(0, fromAccountId, -amount);
            transactionDao.saveTransaction(transaction);

            transaction = new Transaction(0, toAccountId, amount);
            transactionDao.saveTransaction(transaction);
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }
}