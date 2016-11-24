import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale defloc = Locale.getDefault();
		Locale.setDefault(Locale.GERMAN);
		System.out.println(Locale.getDefault());
		Locale.setDefault(defloc);
		
		
		List<String> colors = new ArrayList<>(); // create arraylist and assign it to List
		colors.add("red");  // add elements to arraylist
		colors.add("green");
		colors.add("yellow");
		colors.add("blue");
		colors.add("maroon");
		colors.add(" maroon");
		colors.add("Maroon");
		Collections.sort(colors); // sort the string elements alphabetically
		System.out.println("sorted list" + colors);//print sorted arraylist
		
		
		try {
			FileWriter fw = new FileWriter("testing.txt");
//			fw.write("Testing");
//			fw.flush();
//			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer i1 = 1000;
		Integer i2 = 1000;
		
		System.out.println(i1==i2);
		
		Integer i3 = 10;
		Integer i4 = 10;
		
		System.out.println(i3==i4);
		
		List<String> a = new ArrayList<>();
		a.add("C");
		a.add("B");
		a.add(" c");
		
		System.out.println(a);
		Collections.sort(a);
		System.out.println(a);
		
		
		String REGEX = "\\Sto\\S|\\bo\\b";
		String INPUT = "Nice to see you,to,be fine.";
		String REPLACE = ",";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT);
		INPUT = m.replaceAll(REPLACE);
		System.out.println(INPUT);
		
		
		StringBuffer str = new StringBuffer("3");
		StringBuilder strb = new StringBuilder("5");
		String s = "s";
//		System.out.println(1+2+str+4+5);
//		System.out.println(1+2+strb+4+5);
		System.out.println(1+2+s+3+4);

	}

}
