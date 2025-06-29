package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.ps.Studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAO;

public class Signup {
		public static void signup() { 
			  StudentDAO sdao=new StudentDAOImpl(); //creating ref of StudentDAO interface 
			  Scanner sc=new Scanner(System.in); 
			  //creating an object of pojo class 
			  Student s=new Student(); 
			  //collecting the data from the user 
			  System.out.println("Enter the name:"); 
			  //String name=sc.next(); 
			  //s.setName(name); 
			  s.setName(sc.next()); 
			  System.out.println("Enter the phone number"); 
			  s.setPhone(sc.nextLong()); 
			  System.out.println("Enter the mail ID"); 
			  s.setMail(sc.next()); 
			  System.out.println("Enter the branch"); 
			  s.setBranch(sc.next()); 
			  System.out.println("Enter the Location"); 
			  s.setLoc(sc.next()); 
			  System.out.println("Set the new password"); 
			  String password=sc.next(); 
			  System.out.println("Confirm the password"); 
			  String confirmPassword=sc.next(); 
			  
			  if(password.equals(confirmPassword)) { 
			   s.setPassword(confirmPassword); 
			   boolean res=sdao.insertStudent(s); 
			   if(res) {
				   System.out.println("Data added successfully!"); 
			   } 
			   else { 
			    System.out.println("Failed to add the data"); 
			   } 
			    
			  } 
			  else { 
			   System.out.println("Password mismatch!"); 
			  }   
			} 
			   }

