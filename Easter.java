import javax.swing.JOptionPane;


public class Easter{
	public static void  main(String[] args){
		int year, month, day, easterDate, daysInYear, isLeap;
		String isMarch, answer;
		String input = JOptionPane.showInputDialog("Please write the wanted year (>2000) : ");
		year = Integer.parseInt(input);

		easterDate = Calendar.findEaster(year);

		daysInYear = easterDate - Calendar.numberOfDays(01,01,year);		//amount of days in the year chosen
		isLeap = year%4==0 ? 1 : 0;					//extra leap year day
		
		if (daysInYear < (91 + isLeap) ){			//finds how many months will be used to fit
			month = 03;					//the amount of days found in daysInYear
			day = daysInYear - 59 - isLeap;			//then finds the day by finding how many days
		}							//will fit in the last one
		else{		
			month = 04;
			day = daysInYear - 90 - isLeap;
		}
		
		isMarch = ( month == 03 ) ? "March" : "April" ;		//the month, since it is either march or april
		answer = isMarch + " " + day ;			//returns the month and the date in one line of string

		JOptionPane.showMessageDialog(null,"The Date for Easter in " + year + " is : " + answer );
		
		
	}
}