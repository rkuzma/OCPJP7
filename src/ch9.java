import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ch9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			File file = new File( // just an object
			"fileWrite2.txt");
			FileWriter fw =
			new FileWriter(file); // create an actual file
			// & a FileWriter obj
			fw.write("howdy\nfolks\n"); // write characters to
			// the file
			fw.flush(); // flush before closing
			fw.close(); // close file when done
			FileReader fr =
			new FileReader(file); // create a FileReader
			// object
			char[] in = new char[50];
			int size = fr.read(in); // read the whole file!
			System.out.print(size + " "); // how many bytes read
			for(char c : in) // print the array
			System.out.print(c);
			fr.close(); // again, always close
			} 
		catch(IOException e) { }

		
//		String name = "";
//		Console c = System.console(); // #1: get a Console
//		char[] pw;
//		pw = c.readPassword("%s", "pw: "); // #2: return a char[]
//		for(char ch: pw)
//		c.format("%c ", ch); // #3: format output
//		c.format("\n");
//		MyUtility mu = new MyUtility();
//		while(true) {
//		name = c.readLine("%s", "input?: "); // #4: return a String
//		c.format("output: %s \n", mu.doStuff(name));
//		}
		
		//NIO
		Path source = Paths.get("file"); // exists
		Path target = Paths.get("test2.txt"); // doesn't yet exist
		try {
			Files.createFile(source);
			//Files.copy(source, target); // now two copies of the file
			//Files.delete(target); // back to one copy
			//Files.move(source, target); // still one copy
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//resolve
		Path absolute = Paths.get("/home/java");
		Path relative = Paths.get("dir");
		Path file = Paths.get("Model.pdf");
		System.out.println("1: " + absolute.resolve(relative));
		System.out.println("2: " + absolute.resolve(file));
		System.out.println("3: " + relative.resolve(file));
		System.out.println("4: " + relative.resolve(absolute)); // BAD
		System.out.println("5: " + file.resolve(absolute)); // BAD
		System.out.println("6: " + file.resolve(relative)); // BAD

		
		
		Date januaryFirst = new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime();
		// old way
		File file1 = new File("c:/temp/file");
		file1.createNewFile(); // create the file
		file1.setLastModified(januaryFirst.getTime()); // set time
		System.out.println(file1.lastModified()); // get time
		file1.delete(); // delete the file
		// new way
		Path path = Paths.get("c:/temp/file2");
		try {
			Files.createFile(path);
			FileTime fileTime = FileTime.fromMillis(januaryFirst.getTime()); // FileTime object
			Files.setLastModifiedTime(path, fileTime); // set time
			System.out.println(Files.getLastModifiedTime(path)); // get time
			Files.delete(path); // d
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // create another file

		
		
		//Globs
		
		Path path1 = Paths.get("/com/java/One.java");
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("0*b/test/1");
		System.out.println(matcher.matches(path1, "glob:*.java")); // false
		System.out.println(matcher.matches(path1, "glob:**/*.java")); // true
		System.out.println(matcher.matches(path1, "glob:*")); // false
		System.out.println(matcher.matches(path1, "glob:**")); // true
		
//		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
		System.out.println(matcher.matches(path1));
		
		Path path11 = Paths.get("0*b/test/1");
		Path path2 = Paths.get("9\\*b/test/1");
		Path path3 = Paths.get("01b/test/1");
		Path path4 = Paths.get("0*b/1");
		String glob = "glob:[0-9]\\*{A*,b}/**/1";
		System.out.println(matcher.matches(path11, glob)); // true
		System.out.println(matcher.matches(path2, glob)); // false
		System.out.println(matcher.matches(path3, glob)); // false
		System.out.println(matcher.matches(path4, glob)); // false
		
		
		
		//Watch Service
		
		Path dir = Paths.get("/dir"); // get directory containing
		// file/directory we care
		// about
		WatchService watcher = FileSystems.getDefault().newWatchService(); // create empty watch service
		dir.register(watcher, ENTRY_DELETE); // needs a static import!
		// start watching for
		// deletions
		while (true) { // loop until say to stop
			WatchKey key;
			try {
				key = watcher.take(); // wait for a deletion
			} catch (InterruptedException x) {
				return; // give up if something goes
				// wrong
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name()); // create/delete/modify
				System.out.println(kind.type()); // always a Path for us
				System.out.println(event.context()); // name of the file
				String name = event.context().toString();
				if (name.equals("directoryToDelete")) { // only delete right
														// directory
					System.out.format("Directory deleted, now we can proceed");
					return; // end program, we found what
					// we were waiting for
				}
			}
			key.reset(); // keep looking for events
		}
		
		List<String> test = new ArrayList<>();
		
		//Serialization
		
		Cat c = new Cat(); // 2
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(c); // 3
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			c = (Cat) ois.readObject(); // 4
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class MyUtility { // #5: class to test
	String doStuff(String arg1) {
		// stub code
		return "result is " + arg1;
	}
}
