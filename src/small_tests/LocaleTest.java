package small_tests;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale default_loc = Locale.getDefault();
		System.out.println(default_loc);
		
		Locale lc1 = new Locale("EN", "EN");
		Locale lc2 = new Locale("Es", "ES");
		Locale lc3 = new Locale("FR", "FR");
		Locale lc4 = Locale.CANADA;
		
		
		System.out.println(lc1.getLanguage());
		System.out.println(lc2.getLanguage());
		System.out.println(lc3.getLanguage());
		System.out.println(lc4.getLanguage() + lc4.getCountry());
		
		

	}

}
