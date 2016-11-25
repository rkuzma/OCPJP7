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
	}
	
}
