package in.pentagon.studentapp.model;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.CSVExporter;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.ps.Studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAO;

public class index {
	 
	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAOImpl();
        ArrayList<Student> students = sdao.getStudent();

		String path = "C:\\Users\\DELL\\eclipse-workspace\\studentApp\\students.csv";
		CSVExporter.exportStudentsToCSV(students, path);
		Scanner sc=new Scanner(System.in);
				int choice=0;
				System.out.println("welcome to student app");
				do {
					System.out.println("1.SIGNUP");
					System.out.println("2.LOGIN");
					System.out.println("3.FORGOT PASSWORD");
					System.out.println("4.EXIT");
					choice=sc.nextInt();
					switch(choice) {
					case 1:Signup.signup();
						break;
					case 2:Login.login();
						break;
					case 3:Password.forgot();
						break;
					case 4:System.out.println("thankyou");
						break;
						default:System.out.println("invalid choice,enter the valid choice");
						break;
					}
						
					}while(choice!=4);

}
}
