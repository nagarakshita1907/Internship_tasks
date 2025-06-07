import java.util.Scanner;
public class demo {
	public static void main (String[] args) { 
		
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the first integer: ");
      int num1 = sc.nextInt();
      System.out.print("Enter the second integer: ");
      int num2 = sc.nextInt();
      System.out.print("Enter a floating-point number: ");
      float floatNum = sc.nextFloat();
      System.out.print("Enter a single character: ");
      char ch = sc.next().charAt(0);
      System.out.print("Enter a boolean value (true/false): ");
      boolean value = sc.nextBoolean();
      System.out.print("Enter your name: ");
      String name = sc.next();
      sc.nextLine();
      
      System.out.println("Sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
      System.out.println("Difference between " + num1 + " and " + num2 + " is: " + (num1 - num2));
      System.out.println("Product of " + num1 + " and " + num2 + " is: " + (num1 * num2));
      System.out.println(floatNum + " multiplied by 2 is: " + (floatNum * 2));
      System.out.println("The next character after '" + ch + "' is: " + (char)(ch + 1));
      System.out.println("The opposite of " + value + " is: " + !value);
      System.out.println("Hello, " + name + "!");
}
}
