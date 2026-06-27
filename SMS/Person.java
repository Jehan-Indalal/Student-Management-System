package SMS;
public class Person extends User {

    private String name;
    private int age;

    public Person(String role, String name, int age) {
        super(role);
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if(age>0){
        this.age = age;
    }
    }
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    @Override
    public void showInfo() {
        System.out.println("Role: " + getRole());
        displayDetails();
    }
}