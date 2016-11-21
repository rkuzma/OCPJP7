import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Generics {

	int fakt(int n){
		if(n==0 || n==1){
			return 1;
		}
		//int temp = n * fakt(n-1);
		int temp = n*fakt(n-1);
		return temp;
	}
	
	public <T> void makeArrayList(T t) { // take an object of an
		// unknown type and use a
		// "T" to represent the type
		List<T> list = new ArrayList<T>(); // now we can create the
		// list using "T"
		list.add(t);
	}
	
	public <T> T returnArrayList(T t) { // take an object of an
		// unknown type and use a
		// "T" to represent the type
		List<T> list = new ArrayList<T>(); // now we can create the
		// list using "T"
		list.add(t);
		
		return list.get(0);
	}
	
//	void takeListOfStrings(List<String> strings) {
//		strings.add(new Integer(42));     // NO!! strings is type safe
//		}

	
	public static void main(String[] args) {
		
		Generics test = new Generics();
		System.out.println(test.fakt(10));
		
		
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
		
		//Generics methods
		
		Dog1[] dogs = {new Dog1(), new Dog1()};
		Cat[] cats = {new Cat(), new Cat(), new Cat()};
		Bird[] birds = {new Bird()};
		AnimalDoctor doc = new AnimalDoctor();
		doc.checkAnimals(dogs); // pass the Dog[]
		doc.checkAnimals(cats); // pass the Cat[]
		doc.checkAnimals(birds); // pass the Bird[]
		
		
		
		
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(3);
		Bar bar = new Bar();
		bar.doInsert(myList);
		
		
		List<Integer> myList1 = new ArrayList<Integer>();
		myList1.add(4);
		myList1.add(6);
		Inserter in = new Inserter();
		in.insert(myList1); // pass List<Integer> to legacy code
		for (Integer i: myList1){
			System.out.println(i);
			
		}

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
	static class ReSortComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}

}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		list.add(new Integer(42)); // adds to the incoming list
		list.add(new String("Hello"));
	}
}

class Bar {
void doInsert(List<?> list) {
//list.add(new Dog());
System.out.println(list.get(0));
}
}

abstract class Animal1 {
	public abstract void checkup();
}

class Dog1 extends Animal1 {
	public void checkup() {
		// implement Dog-specific code
		System.out.println("Dog checkup");
	}
}

class Cat extends Animal1 {
	public void checkup() {
		// implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal1 {
	public void checkup() {
		// implement Bird-specific code
		System.out.println("Bird checkup");
	}
}

 class AnimalDoctor {
	// method takes an array of any animal subtype
	public void checkAnimals(Animal1[] animals) {
		for (Animal1 a : animals) {
			a.checkup();
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
