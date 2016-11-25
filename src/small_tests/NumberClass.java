package small_tests;

public class NumberClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Deeper {
public Number getDepth() {
return 10;
}
}

class deep extends Deeper {
protected Integer getDepth(){
return 5;
}}

 class deep2 extends Deeper {
public Double getDepth() {
return 5d;
}}

 class deep3 extends Deeper {
public String getDepth () {
}}

 class deep4 extends Deeper {
public Long getDepth (int d) {
return 5L;
}}
 class deep5 extends Deeper {
public Short getDepth () {
return 5;
}}