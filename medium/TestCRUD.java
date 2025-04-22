import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCRUD {
    public static void main(String[] args) {
        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                                          .addAnnotatedClass(Student.class)
                                                          .buildSessionFactory();

        // Create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // Create a new student
            Student newStudent = new Student(1, "John Doe", 20);

            // Start a transaction
            session.beginTransaction();

            // Save the student
            session.save(newStudent);

            // Commit the transaction
            session.getTransaction().commit();

            // Get the student by ID
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student fetchedStudent = session.get(Student.class, 1);

            // Print the student details
            System.out.println(fetchedStudent);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
