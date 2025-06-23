package sms;


import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Integer, Student> studentMap = new HashMap<>();
    private TreeSet<Student> studentSet = new TreeSet<>();
    String filename="students.data";
	private ArrayList<?> obj;
    public StudentManager() {
        students = new ArrayList<>();
        studentMap = new HashMap<>();
        studentSet = new TreeSet<>();
    }

    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            System.out.println("ID already exists.");
            return;
        }
        students.add(student);
        studentMap.put(student.getId(), student);
        studentSet.add(student);
        System.out.println("Student added.");
    }

    public void removeStudent(int id) {
        Student student = studentMap.remove(id);
        if (student != null) {
            students.remove(student);
            studentSet.remove(student);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudent(int id, String name, int age, String grade, String address) {
        Student student = studentMap.get(id);
        if (student != null) {
            studentSet.remove(student);
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            student.setAddress(address);
            studentSet.add(student);
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudent(int id) {
        return studentMap.get(id);
    }

    public void displayAllStudents() {
        if (studentSet.isEmpty()) {
            System.out.println("⚠️ No students to display.");
            return;
        }
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(students);
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

   
    @SuppressWarnings("unchecked")
	public void loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) in.readObject();
            if (obj instanceof ArrayList<?>) {
                students = (ArrayList<Student>) obj;
            } else {
                System.out.println("⚠️ File does not contain valid student data.");
                students = new ArrayList<>();
            }

           studentMap.clear();
            studentSet.clear();
            if (students != null) {
                for (Student student : students) {
                    studentMap.put(student.getId(), student);
                    studentSet.add(student);
                }
            }

            System.out.println("Data loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
                System.out.println("Could not load students. Starting fresh.");
                students = new ArrayList<>();
                studentMap = new HashMap<>();
                studentSet = new TreeSet<>();
            }
        }
  }
