package small_tests;

enum EnumTest {
BEGINNER;
static{ System.out.println("static init block"); }
EnumTest(){
System.out.println("constructor");
}
public static void main(String... args){
System.out.println(EnumTest.BEGINNER);
}
}