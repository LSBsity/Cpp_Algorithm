import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        boolean check = false;        
        for (var i : numbers) {
            if (i > 0) check = true;
        }
        if (!check) return "0";
        
        Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (o1, o2) -> {
            String s1 = o1 + String.valueOf(o2);
            String s2 = o2 + String.valueOf(o1);
            return Integer.parseInt(s2) - Integer.parseInt(s1);
        });

        return Arrays.stream(arr).map(String::valueOf)
                .collect(Collectors.joining());
    }
}