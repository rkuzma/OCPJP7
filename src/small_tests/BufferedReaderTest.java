package small_tests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null; // neskompiluje ale ked dam do try je to OK
		try ( br = new BufferedReader(new FileReader("test.txt")))
		{

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
