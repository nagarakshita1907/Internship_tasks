package sms;

	import java.io.Serializable;
	import java.util.Objects;

	public class Student implements Serializable, Comparable<Student> {
		private static final long serialVersionUID = 1L;
	    private int id;
	    private String name;
	    private int age;
	    private String grade;
	    private String address;

	    public Student(int id, String name, int age, String grade, String address) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.grade = grade;
	        this.address = address;
	    }

	    // Getters and Setters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public String getGrade() { return grade; }
	    public String getAddress() { return address; }

	    public void setName(String name) { this.name = name; }
	    public void setAge(int age) { this.age = age; }
	    public void setGrade(String grade) { this.grade = grade; }
	    public void setAddress(String address) { this.address = address; }

	    @Override
	    public String toString() {
	        return String.format("ID: %d | Name: %s | Age: %d | Grade: %s | Address: %s",
	                id, name, age, grade, address);
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Student)) return false;
	        Student student = (Student) o;
	        return id == student.id;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }

	    @Override
	    public int compareTo(Student other) {
	        return Integer.compare(this.id, other.id); // or this.name.compareTo(other.name)
	    }
	}


