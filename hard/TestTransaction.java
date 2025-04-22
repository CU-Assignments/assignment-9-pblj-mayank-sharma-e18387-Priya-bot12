import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTransaction {
    public static void main(String[] args) {
        // Load Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the BankService bean
        BankService bankService = context.getBean(BankService.class);

        try {
            // Test successful transaction
            bankService.transferMoney(1, 2, 100);
            System.out.println("Transaction Successful");
        } catch (RuntimeException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        context.close();
    }
}
