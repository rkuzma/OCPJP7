
public class Generics {

	public static void main(String[] args) {
		Integer i1 = 5;
		Integer i2 = 6;

		if (i1 == i2) {
			System.out.println("True");
		} else
			System.out.println("False");

		Moof one = new Moof(8);
		Moof two = new Moof(8);

		if (one.equals(two)) {
			System.out.println("one and two are equal");
		}

	}

}

class Moof {
	private int moofValue;

	Moof(int val) {
		moofValue = val;
	}

	public int getMoofValue() {
		return moofValue;
	}

	public boolean equals(Object o) {
		if ((o instanceof Moof) && (((Moof) o).getMoofValue() == this.moofValue)) {
			return true;
		} else {
			return false;
		}
	}
	public int hashCode() { return (moofValue * 17); }

}
