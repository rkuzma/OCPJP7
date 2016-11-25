package small_tests;

public class MultiThreadExcep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread sing = new Sing();
		sing.start();
		throw new RuntimeException("main");
	}

}

class Sing extends Thread {
	public void run() {
		System.out.println("Singing");
		throw new RuntimeException("run");
	}
}