package small_tests;

public class ClassInheritance extends CueSports implements Event {

	public static void main(String[] args) {
		
		Event obj1 = new ClassInheritance(); // Line 11
		CueSports obj2 = new ClassInheritance(); // Line 12
		System.out.print(obj1.getCategory() + ", " + obj2.getCategory());
		// TODO Auto-generated method stub

	}

}
interface Event {
String getCategory();
}
class CueSports {
public String getCategory() {
return "Cue sports";
}}