package small_tests;

public class InterfaceTest {

	public static void main(String[] args) {
		Rideable r1 = new Icelandic();
		Rideable r2 = new Horse();
		Horse h1 = new Icelandic();
		System.out.println(r1.ride() + r2.ride() + h1.ride());
		}
}

interface Rideable {
public String ride();
}
class Horse implements Rideable {
public String ride() { return "cantering "; }
}
class Icelandic extends Horse implements Rideable {
public String ride() { return "tolting "; }
}
