package small_tests;

public class StaticBlocks {

	static {
		++staticVar;
	}

	static int staticVar;

	static {
		++staticVar;
	}

	public StaticBlocks() {
		System.out.println("Constructor:" + staticVar);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new StaticBlocks();
	}

}
