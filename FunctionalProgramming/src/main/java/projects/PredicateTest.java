package projects;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    //Imperative Approach
    public boolean isEqualToTen(int num1){ return num1==10; }
    public boolean isEqualToTenBi(int num1, int num2){ return num1==10 && num2==10; }

    //Declarative Approach
    Predicate<Integer> isEqualToTen = n -> n == 10;

    BiPredicate<Integer,Integer> isEqualToTenBi = (n,i) -> n ==10 && i==10;
}
