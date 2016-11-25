package small_tests;

public class ReplaceTest {

	
	public static void main (String args[]){
	String str = "cat cup copp";
	//String newString = str.replaceAll("c.p\\b", "()"); //line4
	String newString = str.replace(new StringBuilder("cat"), "()");
	System.out.println(newString);
	
}
}