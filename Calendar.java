import java.util.*;

public class Calendar{

	final public static double MOONCONS = 29.53;


	public static int numberOfDays(int month, int day, int year){

		int deltaDay= day - 1 ;      //Calculates Difference
        	int deltaMonth = month - 1;  //with the initial condition
	        int deltaYear = year - 2000; //from 01 01 2000 (Saturday)
	
        	int leap = ((deltaYear-1)/4) + 1 ; //nbr of leap years
	        int yearsToDays = (deltaYear - leap) *365 + leap * 366; //turns years to days

	        int monthsToDays = 31 * deltaMonth;				//turns months to days
        	if (deltaMonth >1 && deltaMonth<8 ){				//by first assuming all
	            monthsToDays = monthsToDays - (1 + deltaMonth/2);		//months have 31 days
        	}								//then find the nmbr of month
        	else if (deltaMonth>7){						//that have 30, then substract
            	monthsToDays = monthsToDays - (4 + ((deltaMonth-7)/2));	//it from the original value
        	}								
        	if (deltaYear%4!=0 && deltaMonth>1){				//makes sure that February has
            	monthsToDays -=1;						// 28 days, then substracts it from original
        	}

		int totalDays = deltaDay + monthsToDays + yearsToDays;
		return totalDays;
		}
	

	public static String findDay(int totalDays){

		String[] week = {"SATURDAY" , "SUNDAY" , "MONDAY" , "TUESDAY" ,  "WEDNESDAY" , "THURSDAY"  , "FRIDAY" };   //array of all week days
        	int index = totalDays % 7;   // %7 will eliminate every week that passed, keeping only the remainder, multiplying by nine to get the wanted index
        	String answer =  week[index];
        	return answer;
	}


	public static int nextFullMoon(int month, int day, int year){
		int date =  numberOfDays(month,day,year) - 20;  
		int nextFullMoon = (int) Math.round( (Math.floor(date / MOONCONS) * MOONCONS) + MOONCONS + 1.15 ) + 20;  //will return nextFullMoon date(numberOfDays) by
		return nextFullMoon;										//finding the date of the last full moon, then 
	}													//adding the time for one full moon.

	public static int findEaster(int year){
		int date, weekday, easterDate;
		String answer, isMarch;

		date = nextFullMoon(03,21,year);
		weekday = date%7;
		if ( weekday < 2){						//calculates the amount of days for easter, 
			easterDate = date + ( 2 - weekday );			//by finding the day of the week for nextDate,
		}								//then add a constant to get it to the next Sunday

		else{		
			easterDate = date + (9 - weekday );
		}	
		return easterDate;
	
	}
	
}







