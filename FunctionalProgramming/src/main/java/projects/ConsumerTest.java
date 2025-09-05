package projects;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

    //Imperative Approach
    public void printName(String name){ System.out.println(name); }
    public void printNameBi(String name1, String name2){ System.out.println(name1+"\n"+name2); }

    //Declarative Approach
    Consumer<String> printName = name -> System.out.println(name);
    Consumer<String> printNameMethodReference = System.out::println;

    BiConsumer<String,String> printNameBi = (a,b) -> System.out.println(a+"\n"+b);


}
