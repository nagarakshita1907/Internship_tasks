package sms;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadFromFile("Book1");  // Load data at start
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit & Save");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    if (id < 0 || age <= 0 || name.isEmpty() || address.isEmpty()) {
                        System.out.println("Invalid input.");
                    } else {
                        manager.addStudent(new Student(id, name, age, grade, address));
                    }
                }

                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    int id = sc.nextInt();
                    manager.removeStudent(id);
                }

                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter New Address: ");
                    String address = sc.nextLine();
                    manager.updateStudent(id, name, age, grade, address);
                }

                case 4 -> {
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();
                    Student student = manager.searchStudent(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                }

                case 5 -> manager.displayAllStudents();

                case 6 -> {
                    manager.saveToFile("students.dat");  // Save data before exit
                    System.out.println("Exited!");
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}