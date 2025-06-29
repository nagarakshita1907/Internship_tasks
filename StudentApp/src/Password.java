package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.ps.Studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;

public class Password {
	public static void forgot() {
		StudentDAO sdao=new StudentDAOImpl();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the phone number:");
		long phone=sc.nextLong();
		System.out.println("Enter the mail id:");
		String mail=sc.next();
		Student s=sdao.getStudent(phone, mail);
		if(s!=null) {
			System.out.println("Set a new password");
			String password=sc.next();
			System.out.println("Confirm the password");
			String confirm=sc.next();
			if(password.equals(confirm)) {
				s.setPassword(password);
				boolean res=sdao.updateStudent(s);
				if(res) {
				System.out.println("Password updated!");
			}
				else {
					System.out.println("Update failed");
				}
		} else {
			System.out.println("Password mismatched");
		}	
	}else {
		System.out.println("Student not found!");
	}
}
}
	
