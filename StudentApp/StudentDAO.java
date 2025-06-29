package in.pentagon.studentapp.dao;

import java.util.ArrayList;

import in.ps.Studentapp.dto.Student;

public interface StudentDAO {

	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail,String password);
	public Student getStudent(long phone, String mail);
	public ArrayList<Student> getStudent();
	ArrayList<Student> getStudent(String name);
	boolean deleteStudent(int id);
	public Student searchStudent(int id);
	
}

