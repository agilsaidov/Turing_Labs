package projects;

import java.util.NoSuchElementException;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OptionalCustom<String> optional = new OptionalCustom<>(null);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());

        try {
            System.out.println(optional.get());
        }catch (NoSuchElementException e){
            System.out.println("Vusal Muellime Salam");
        }

        System.out.println(optional.toString());
    }
}