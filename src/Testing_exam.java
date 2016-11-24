
public class Testing_exam {
	
	public static int getCount(String[] arr) {
		int count =0 ;
		for(String var:arr) {
		if(var!=null) count++;
		}
		return count;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr =new String[4];
		arr[1] = "C";
		arr[2] = "";
		arr[3] = "Java";
		assert (getCount(arr) < arr.length);
		System.out.print(getCount(arr));
		
		
		int[] arr1 = {105,78,56};
		try {
			new Test1().verify(arr1);
			} catch (ArrayIndexOutOfBoundsException | MarkOutOfBoundsException e) {
			System.out.print(e.getClass());
			}
	}

}

class MarkOutOfBoundsException extends ArrayIndexOutOfBoundsException {}
class Test1 {
public void verify(int[] arr) throws ArrayIndexOutOfBoundsException {
for (int i = 1; i <= 3; i++) {
if(arr[i] > 100)
throw new MarkOutOfBoundsException();
System.out.println(arr[i]);
}
}
}

final class FinalShow { // Line 1
final String location; // Line 2
FinalShow(final String loc) { // Line 3
location = loc; // Line 4
} // Line 5
FinalShow(String loc, String title) { // Line 6
location = loc; // Line 7
loc = "unknown"; // Line 8
} // Line 9
} // Line 10