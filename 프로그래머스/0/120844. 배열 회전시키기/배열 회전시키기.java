import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        if (direction.equals("right")) {
            Collections.rotate(list, 1);
        } else {
            Collections.rotate(list, numbers.length - 1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}