package small_tests;

public class MarkOutOfBoundsException extends ArrayIndexOutOfBoundsException {
}

public class StaticTest2 {
	public void verify(int[] arr)

			throws ArrayIndexOutOfBoundsException {
		for (int i = 1; i <= 3; i++) {
			if (arr[i] > 100)
				throw new MarkOutOfBoundsException();
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 105, 78, 56 };
		try {
			new StaticTest2().verify(arr);
		} catch (ArrayIndexOutOfBoundsException | MarkOutOfBoundsException e) {
			System.out.print(e.getClass());
		}
	}
}
