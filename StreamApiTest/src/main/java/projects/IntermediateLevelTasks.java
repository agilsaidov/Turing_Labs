package projects;

import java.util.Arrays;
import java.util.List;

public class IntermediateLevelTasks {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(47, 12, 89, 33, 5, 76, 58, 99, 24, 63, 17, 42, 99, 80, 6, 28, 95);
        List<String> words = Arrays.asList("mountain", "river", "java", "cloud", "stream", "river", "forest",
                                            "tree", "castle", "sunshine", "mountain", "night", "dream", "galaxy");



       // Find the second-highest number in a list of integers using streams (without sorting the whole list).

        System.out.println(
        numbers.stream().distinct().sorted((n,m) -> m - n).skip(1).mapToInt(Integer::intValue).findFirst().getAsInt());


       // Remove duplicates from a list of strings but keep the first occurrence only.

        words.stream().distinct();


       // Given a list of sentences, find the most frequent word using streams.




       // Convert a list of Person(name, age) objects into a Map<String, Integer> where the key is the name and the value is the age, but only include people older than 18.




       // Given a list of transactions (id, customerId, amount), calculate the total spending per customer.


    }
}
