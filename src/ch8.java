import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ch8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d1 = new Date(1_000_000_000_000L);
		System.out.println("1st date " + d1.toString());
		Calendar c = Calendar.getInstance();
		c.setTime(d1); // #1
		if(Calendar.SUNDAY == c.getFirstDayOfWeek()) // #2
		System.out.println("Sunday is the first day of the week");
		System.out.println("trillionth milli day of week is "
		+ c.get(Calendar.DAY_OF_WEEK)); // #3
		c.add(Calendar.MONTH, 1); // #4
		Date d2 = c.getTime(); // #5
		System.out.println("new date " + d2.toString() );
		System.out.println("new date " + c.toString() );

		
		DateFormat[] dfa = new DateFormat[6];
		dfa[0] = DateFormat.getInstance();
		dfa[1] = DateFormat.getDateInstance();
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
		for(DateFormat df : dfa)
		System.out.println(df.format(d1));
		}
	
	
		

}
