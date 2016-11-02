import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Animal {
    public void eat() {System.out.println("Testing animal....");}
    public void animal_test() {System.out.println("Testing animal....");}
    public void test() {};
}

private class Dog extends Animal {
    public void eat() {System.out.println("Testing dog....");}
    public void test() {System.out.println("Testing dog test....");}
//    public String doStuffa(String a) {a = a.concat(" ef h ");return a.trim();
    public String doStuffa(String a) {a = a.concat(" ef h "); return a.trim();
    }
    
    public static void main(String[] args) {

        Animal dog = new Dog();
      
        dog.eat();
        dog.animal_test();
        dog.test();
        
//        System.out.printf("%2$d +%1$d", 123, 456);
//        int i1 = -123;
//        int i2 = 12345;
//        int i3 = 123;
//        System.out.println("");
//        System.out.printf(">%1$(7d< \n", i1);
//        System.out.printf(">%1$(7d< \n", i3);
//        System.out.printf(">%0,7d< \n", i2);
//        System.out.format(">%+-7d< \n", i2);
//        System.out.printf(">%2$b + %1$5d< \n", i1, false);
        
//        Pattern p = Pattern.compile("\\B");
//        Matcher m = p.matcher("^23 *$76 bc");
//        boolean b = false;
//        while(b = m.find()) {
//        System.out.print(m.start() + m.group());
//        }
        
        String in = "1 a2 b 3 c4d 5e";
        String[] chunks = in.split("\\d");
        System.out.println("count " + chunks.length);
        for(String s : chunks)
        System.out.print(">" + s + "< ");
        
        

        Dog da = new Dog();
        String a = " ab c ";
        System.out.println(">" + da.doStuffa(a) + "<");
        String b = da.doStuffa(a);
        System.out.println(">" + b + "<");
        
        try{
        boolean newFile = false;
        File file = new File("myDir", "test");
        FileWriter fw =new FileWriter(file);
        file.createNewFile();
        fw.write("howdy\nfolks\n");
        fw.flush();
        fw.close();
        System.out.println(newFile);
        System.out.println(file.exists());
        } 
        catch(IOException e) { }
        

        
        
//      
//        Animal animal = new Animal();
//        Dog dog1 = (Dog) animal;
//        dog1.eat();
    }
}