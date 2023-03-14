import java.util.*;

public class Date{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Write the desired date (MM/DD/YYYY): ");
		int month = sc.nextInt();
		int day = sc.nextInt();
		int year = sc.nextInt();
		String res = Calendar.findDay(Calendar.numberOfDays(month,day,year));
		System.out.println("That day was/is/will be a " + res);
	}
}

