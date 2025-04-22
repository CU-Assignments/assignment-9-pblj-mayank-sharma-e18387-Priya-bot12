import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring context from AppConfig
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Student bean and print details
        Student student = context.getBean(Student.class);
        student.printStudentDetails();

        context.close();
    }
}
