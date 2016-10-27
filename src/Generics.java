import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Generics {

	public static void main(String[] args) {
		Integer i1 = 5;
		Integer i2 = 6;

		if (i1 == i2) {
			System.out.println("True");
		} else
			System.out.println("False");

		Moof one = new Moof(8);
		Moof two = new Moof(8);

		if (one.equals(two)) {
			System.out.println("one and two are equal");
		}
		
		Integer y = 120;
		Integer x = 120; 
//		System.out.println(y==x);
		if(x == y) System.out.println("same object");
		System.out.println(y.equals(x));

		Integer i3 = 10;
		Integer i4 = 10;
		if(i3 == i4) System.out.println("same object");
		if(i3.equals(i4)) System.out.println("meaningfully equal");
		ArrayList<String> stuff = new ArrayList<String>();
		stuff.add("c");
		stuff.add("b");
		stuff.add("c");
		System.out.println(stuff.indexOf("c"));
		System.out.println(stuff);
		Collections.sort(stuff);
		System.out.println(stuff);
		System.out.println(stuff.indexOf("c"));
		
		
		
		//Searching collections
		String[] sa = { "one", "two", "three", "four" };
		Arrays.sort(sa);
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));
		System.out.println("now reverse sort");
		ReSortComparator rs = new ReSortComparator();
		Arrays.sort(sa, rs);
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));
		System.out.println("one = " + Arrays.binarySearch(sa, "one", rs));
		
		
		String[] sa1 = {"one", "two", "three", "four"};
		List sList = Arrays.asList(sa1);
		sList.set(3,"six");
		// change List
		sa1[1] = "five";
		// change array
		for(String s : sa1)
		System.out.print(s + " ");
		System.out.println("\nsa1[1] " + sList.get(1));
		
		
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "ant"); map.put("d", "dog"); map.put("h", "horse");
		SortedMap<String, String> submap;
		submap = map.subMap("b", "g");
		map.put("b", "bat");
		submap.put("f", "fish");
//		submap.put("i", "fish");
		
		System.out.println(map + " \n" + submap);
		
		
		
		
	}
	static class ReSortComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}

}


class Moof {
	private int moofValue;

	Moof(int val) {
		moofValue = val;
	}

	public int getMoofValue() {
		return moofValue;
	}

	public boolean equals(Object o) {
		if ((o instanceof Moof) && (((Moof) o).getMoofValue() == this.moofValue)) {
			return true;
		} else {
			return false;
		}
	}
	public int hashCode() { return (moofValue * 17); }

}
