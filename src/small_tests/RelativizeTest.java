package small_tests;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest {

	public static void main(String args[]) {
		Path dir = Paths.get("code");
		Path file = Paths.get("code/java/IO.java");
		System.out.println(file.relativize(dir));

		Path relative = file.resolve(file.relativize(dir));
		System.out.println(relative);

		Path absolute = relative.toAbsolutePath();
		System.out.println(absolute);

		Path path1 = Paths.get("\\sales\\quarter\\..\\qtrlreport.txt");
		path1.relativize(Paths.get("\\sales\\annualreport.txt"));
		
		if (path1.endsWith("annualreport.txt")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		System.out.println(path1);

		Path path2 = Paths.get("\\sales\\quarter\\qtrlreport.txt");
		System.out.println(path2.relativize(Paths.get("\\sales\\annualreport.txt")));
		
		
		
	}

}
