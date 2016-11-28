package small_tests;

class Book {
	static {
		test1 =10;
		int test1 =0;
	}
	static int test = 0; 
	
	static void printName() {
		System.out.println("Book");
	}
}

class CourseBook extends Book {
	void test(){System.out.println("test");}
	static void printName() {
		System.out.println("CourseBook");
		test();
	}
}

public class StaticTest {
	void test(){System.out.println("test");}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book base = new Book();
		base.printName();
		Book derived = new CourseBook();
		derived.printName();
		
		test();
	}

}
