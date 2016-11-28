package small_tests;

import java.io.FileInputStream;
import java.io.IOException;

public class PrintFileTest {

	static public void otherMethod()  {
		printFile("");
	}

	static public void printFile(String file) {
		try (FileInputStream fis = new FileInputStream(file)) {
			System.out.println(fis.read());
		} catch (IOException e) {
			//printStackTrace();
			e.printStackTrace();
		}
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		otherMethod();
	}

}
