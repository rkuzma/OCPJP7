import java.util.ArrayList;
import java.util.List;

public class MahmaGupta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sentence = "paint the cup and the plate";
		System.out.println(sentence.indexOf('a'));
		System.out.println(sentence.indexOf('a', 0));
		System.out.println(sentence.indexOf('a', -100));
		System.out.println(sentence.indexOf('a', 100));
		System.out.println(sentence.lastIndexOf('a'));
		System.out.println(sentence.lastIndexOf('a', 0));
		System.out.println(sentence.lastIndexOf('a', 100));
		System.out.println(sentence.lastIndexOf('a', -100));
		
		
		String str = "cat cup copp";
		String newString = str.replaceAll("c.p\\B", "()");
		System.out.println(newString);
		String newString2 = str.replaceAll("c.p\\b", "()"); //line4
		System.out.println(newString2);
		
		List<String> list = new ArrayList<>();
		
		
		class Person {
			public String toString() {
			return "Pirates of the Caribbean";
			}
			}
		
		System.out.println(new Person());
		boolean b = false;
		assert (b = true) : new Person();
		
		

	}

}

interface Live{
void eat();
}
//abstract class Animal implements Live{}


