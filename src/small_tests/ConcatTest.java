package small_tests;

public class ConcatTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("test");
		StringBuilder sb1 = new StringBuilder("test");
		System.out.println(1+2+s1+4+5);
		System.out.println(1+2+""+sb1+4+5);
	}

}
