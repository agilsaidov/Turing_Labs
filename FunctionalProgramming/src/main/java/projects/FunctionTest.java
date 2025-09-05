package projects;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {

    //Imperative Approach
    public int increment(int num){ return ++num; }

    public int addTwoValues(int num1 , int num2){ return num1+num2; }

    //Declarative Approach
    Function<Integer,Integer> incremenetFunc = num -> num+1;

    BiFunction<Integer,Integer,Integer> addTwoValuesFunc = (num1, num2) -> num1+num2;
    //Ve ya
    BiFunction<Integer,Integer,Integer> addTwoValuesFuncMethodReference = Integer::sum;
}
