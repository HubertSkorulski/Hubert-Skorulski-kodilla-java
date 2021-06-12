package collection;
import java.util.*;

public class OddNumbersExterminator {


    //public OddNumbersExterminator (List numbers) {
    //    this.numbers = numbers;
    //}

    public List<Integer> exterminate (List<Integer> numbers){
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer item : numbers) {
            if (item % 2 == 0) {
                oddNumbers.add(item);
            }
        }
        return oddNumbers;
    }
}
