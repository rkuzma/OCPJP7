package small_tests;

public class ReplaceTest {

	
	public static void main (String args[]){
	String str = "cat cup copp";
	//String newString = str.replaceAll("c.p\\b", "()"); //line4
	String newString = str.replace(new StringBuilder("cat"), "()");
	String test = str.replaceAll("c.p\\B","()");
	String test3 = str.replaceAll("c.p\\b","()");
	System.out.println(test3);
	String test2 = str.replaceAll("c.p\\w","()");
	System.out.println(test);
	System.out.println(test2);
	System.out.println(newString);
	
	
	
}
}