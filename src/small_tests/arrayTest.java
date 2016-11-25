package small_tests;

public class arrayTest {

	public void verify(int[] arr) throws ArrayIndexOutOfBoundsException {
		for (int i = 1; i <= 3; i++) {
		if(arr[i] > 100)
		throw new MarkOutOfBoundsException();
		System.out.println(arr[i]);
		}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {105,78,56};
		try {
		new arrayTest().verify(arr);
		} catch (ArrayIndexOutOfBoundsException | MarkOutOfBoundsException e) {
		System.out.print(e.getClass());
		}

	}

}

class MarkOutOfBoundsException extends ArrayIndexOutOfBoundsException {}