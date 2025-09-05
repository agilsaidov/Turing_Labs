package projects;


import java.util.function.BiFunction;
import java.util.function.Function;

public class MainApp {
    public static void main(String[] args) {

        //Functions
        FunctionTest ft = new FunctionTest();
        ft.addTwoValuesFuncMethodReference.apply(34,47);
        ft.addTwoValuesFunc.apply(23,41);
        ft.incremenetFunc.apply(5);
    }
}