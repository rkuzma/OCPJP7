package small_tests;

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