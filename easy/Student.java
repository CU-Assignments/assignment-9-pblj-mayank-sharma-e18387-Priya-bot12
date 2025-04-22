public class Student {
    private String name;
    private Course course;

    // Constructor injection
    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void printStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Duration: " + course.getDuration());
    }
}
