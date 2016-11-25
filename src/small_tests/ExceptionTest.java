package small_tests;

import java.io.IOException;

class Exception1 extends IOException {
}

class Exception2 extends Exception {
}

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			int a = 10;
			if (a <= 10)
				throw new Exception1();
			else
				throw new Exception2(); // line1
		} catch (Exception1 | Exception2 ex) {
//			catch (Exception | IOException ex) {
			System.out.println(ex);
		}

	}

}
