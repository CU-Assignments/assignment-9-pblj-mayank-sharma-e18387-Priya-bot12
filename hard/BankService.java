

import org.springframework.transaction.annotation.Transactional;

public interface BankService {
    void transferMoney(int fromAccountId, int toAccountId, double amount);
}

