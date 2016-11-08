import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
	
		Pattern p = Pattern.compile("\\d\\w");
		Matcher m = p.matcher("ab4 56_7ab");
		System.out.println("Pattern is "+m.pattern());
		while(m.find()){
	
		System.out.println(m.start() + " " + m.group());
		}
		
		//String.split()
		
		System.out.print("input: ");
		System.out.flush();
		try {
			Scanner s = new Scanner(System.in);
			String token;
			do {
				token = s.findInLine(args[0]);
				System.out.println("found " + token);
			} while (token != null);
		} catch (Exception e) {
			System.out.println("scan exc");
		}
		
		String[] tokens = "ab5 ccc 45 @".split("\\d");
		System.out.println("count " + tokens.length);
		for(String s : tokens){
		System.out.println(">" + s + "<");
		}
			
		
		//Scanner
		boolean b2, b;
		int i;
		String s, hits = " ";
		Scanner s1 = new Scanner("1 true 34 hi");
		Scanner s2 = new Scanner("1 true 34 hi");
		//s2.useDelimiter("\\d");
		while (b = s1.hasNext()) {
			s = s1.next();
			hits += "s";
		}
		while (b = s2.hasNext()) {
			if (s2.hasNextInt()) {
				i = s2.nextInt();
				hits += "i";
			} else if (s2.hasNextBoolean()) {
				b2 = s2.nextBoolean();
				hits += "b";
			} else {
				s2.next();
				hits += "s2";
			}
		}
		System.out.println("hits " + hits);

		
		//StringTokenizer
		StringTokenizer st = new StringTokenizer("a bc d e");
		System.out.println("\n " + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.print(">" + st.nextToken() + "< ");
		}
		System.out.println("\n " + st.countTokens());
		// Second argument "a" is this StringTokenizer's delimiter
		StringTokenizer st2 = new StringTokenizer("a b cab a ba d", "a");
		System.out.println("\n " + st2.countTokens());
		while (st2.hasMoreTokens()) {
			System.out.print(">" + st2.nextToken() + "< ");
		}
		System.out.println("\n " + st2.countTokens());
		
		//Formatting output
		System.out.printf("%2$d + %1$d", 123, 456);
		System.out.println("\n");
		System.out.printf("%d + %d", 123, 456);
		
		int i1 = -123;
		int i2 = 12345;
		System.out.printf(">%1$(7d< \n", i1);
		System.out.printf(">%0,7d< \n", i2);
		System.out.format(">%+-7d< \n", i2);
		System.out.printf(">%2$b + %1$5d< \n", i1, false);
		
		
		//ResourceBundles
		Locale locale = new Locale("fr");
		//ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
		ResourceBundle rb = ResourceBundle.getBundle("Labels");
		System.out.println(rb.getString("hello"));
		
		Locale locale1 = new Locale("en", "CA");
		ResourceBundle rb1 = ResourceBundle.getBundle("Labels", locale1);
		System. out.println(rb1.getObject("hello"));
		
		Locale initial = Locale.getDefault();
		System.out.println(initial);
		// set locale to Germany
		Locale locale2 = new Locale("fr", "CA");
		
		Locale.setDefault(locale2);
		System.out.println(Locale.CANADA);
		System.out.println(Locale.getDefault());
		
		Locale.setDefault(initial);
		System.out.println(Locale.getDefault());
		
		
		//Locale.setDefault(locale2);	Will throw exception
		Locale locale3 = new Locale("fr", "FR");
		ResourceBundle rb2 = ResourceBundle.getBundle("RB", locale);
		System.out.println(rb2.getString("ride.in") +" "+ rb2.getString("elevator"));
		Locale.setDefault(initial);
		
	}
}

class Labels_en_CA extends ListResourceBundle {
	protected Object[][] getContents() {
		return new Object[][] { { "hello", new StringBuilder("from Java") } };
	}
}
