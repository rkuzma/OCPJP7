package small_tests;

public class Assertions {
	
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
		
		System.out.println(arr.length);
		arr[1] = "C";
		arr[2] = "";
		arr[3] = "Java";
		assert(true);
		assert (getCount(arr) < arr.length);
		System.out.print(getCount(arr));

	}

}
