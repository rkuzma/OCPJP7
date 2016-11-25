package small_tests;

public class AssertTest {
	
	public static void main(String args[]) {
		evenOdd(-11);
		}
		static void evenOdd(int num) {
		System.out.println(num%2);
		if (num%2 == 0)
		System.out.println("Even");
		else if (num%2 == 1)
			System.out.println("Odd");
			else {
			System.out.println("This should never be printed");
			assert false : new Person();
			}
			}
			}
			class Person {
			public String toString () {
			return "Pirates of the Caribbean";
			}
			

}
