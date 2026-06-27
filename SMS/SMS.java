package SMS;
import java.util.Scanner;

public class SMS {

    private static Student[] studentArray = new Student[100];
    private static int studentCount = 0;

    private static Scanner input= new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Student Management System Menu ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();

            } else {
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentFeature();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    System.out.println("Exiting Program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }

    public static void addStudent() {
        if (studentCount >= studentArray.length) {
            System.out.println("System Full! Cannot add more students.");
            return;
        }

        System.out.println(" Adding New Student ");

        System.out.print("Enter Student ID: ");
        String id = input.next();

        System.out.print("Enter Student Name: ");
        String name = input.next();

        System.out.print("Enter Student Age: ");
        int age = input.nextInt();


        System.out.print("Enter Student Grade: ");
        double grade = input.nextDouble();



        Student S1 = new Student(name, age, id, grade);

        studentArray[studentCount] = S1;
        studentCount++;

        System.out.println("Student " + name + " added successfully.");
    }

    public static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students found in the system.");
            return;
        }

        System.out.println(" All Student Records (" + studentCount + " Total)");

        for (int i = 0; i < studentCount; i++) {
            studentArray[i].showInfo();
        }
    }

    private static Student findStudentById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i].getId().equalsIgnoreCase(id)) {
                return studentArray[i];
            }
        }
        return null;
    }

    public static void searchStudentFeature() {
        System.out.println(" Search Student ");
        System.out.print("Enter Student ID to search: ");
        String searchId = input.next();

        Student foundStudent = findStudentById(searchId);

        if (foundStudent != null) {
            System.out.println("Student Found:");
            foundStudent.showInfo();
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public static void updateStudent() {
        System.out.println("Update Student ");
        System.out.print("Enter Student ID to update: ");
        String updateId = input.next();

        Student studentToUpdate = findStudentById(updateId);

        if (studentToUpdate != null) {
            System.out.println("Found Student: " + studentToUpdate.getName() + ". What do you want to update?");

            System.out.print("Enter New Name (or press Enter to skip): ");
            input.nextLine();
            String newName = input.nextLine();
            if (!newName.isEmpty()) {
                studentToUpdate.setName(newName);
            }
            

System.out.print("Enter New Age (Enter -1 to skip or update): ");
            
            if (input.hasNextInt()) {
                int newAge = input.nextInt();
              
                
                if (newAge != -1) {
                    if (newAge > 0) {
                        studentToUpdate.setAge(newAge);
                    } else {
                        System.out.println("Age must be positive. Skipping age update."); 
                    }
                }
            } else {
                 
                System.out.println("Skipping Age update."); 
            }
          
            System.out.print("Enter New Grade (Enter -1.0 to skip or update): ");
            
            if (input.hasNextDouble()) {
                double newGrade = input.nextDouble();
             
                
                if (newGrade != -1.0) {
                    studentToUpdate.setGrade(newGrade);
                }
            } else {
               
                System.out.println("Skipping Grade update."); 
            }
            System.out.println("Details updated successfully for " + studentToUpdate.getName());
            studentToUpdate.showInfo();

        } else {
            System.out.println("Student Not Found. Update failed.");
        }
    }
}



