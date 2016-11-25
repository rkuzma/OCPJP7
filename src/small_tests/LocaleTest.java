package small_tests;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale lc1 = new Locale("EN", "EN");
		Locale lc2 = new Locale("Es", "ES");
		Locale lc3 = new Locale("FR", "FR");
		
		System.out.println(lc1.getLanguage());
		System.out.println(lc2.getLanguage());
		System.out.println(lc3.getLanguage());
		

	}

}
