package small_tests;

import java.util.Arrays;

public class arraySort {

	public static void main(String[] args) {
		
		Object[] array1 = new Object[3];
		array1[0] = "foo";
		array1[0] = 1;
		array1[0] = 'a';
		int index = Arrays.binarySearch(array1, "bar");
		System.out.println(index);
		// TODO Auto-generated method stub

	}

}
