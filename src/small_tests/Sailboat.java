package small_tests;


abstract class Boat {
String doFloat() { return "floating"; }
abstract void doDock();
}
class Sailboat extends Boat {
public static void main(String[] args) {
Boat b = new Sailboat(); // Line A
//Boat b2 = new Boat(); // Line B
}
String doFloat() { return "slow float"; } // Line C
void doDock() { } // Line D
}
