package small_tests;

import java.util.Comparator;
import java.util.TreeSet;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<String> set1 = new TreeSet<String>( new Comparator<String>() {
			public boolean compare(String s1, String s2) {
			return s1.length() > s2.length();
			}
			});
		
		set1.add("peach");
		set1.add("orange");
		set1.add("apple");
		for (String n: set1) {
		System.out.println(n);

	}

}
