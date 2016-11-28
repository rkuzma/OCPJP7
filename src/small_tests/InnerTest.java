package small_tests;

public class InnerTest {
	String title;
	static class Counter {
	int counter = 0;
	void increment() { counter++; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InnerTest.Counter().increment();
	}

}