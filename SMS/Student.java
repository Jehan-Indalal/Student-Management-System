package SMS;
public class Student extends Person {
    
    private String id;
    private double grade;

    public Student(String name, int age, String id, double grade) {
        super("Student", name, age); 
        this.id = id;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Grade: " + grade);
    }
    
    @Override
    public void showInfo() {
        System.out.println(" " + getRole() +" "); 
        displayDetails();
      
    }
}
    

