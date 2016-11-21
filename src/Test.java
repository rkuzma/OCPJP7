import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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
		

	}

}
