
public class Inner {
	public static void main(String[] args) {
		Food food = new Food();
		food.p.pop();
	}


}

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}

class Food {
	Popcorn p = new Popcorn() {
		public void pop() {
			System.out.println("anonymous popcorn");
		}
	};
}