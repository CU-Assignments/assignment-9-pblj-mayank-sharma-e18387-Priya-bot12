import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private int id;
    private String accountHolder;
    private double balance;

    public Account() {
        // Default constructor
    }

    public Account(int id, String accountHolder, double balance) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
