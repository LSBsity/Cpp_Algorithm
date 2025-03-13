import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            List<Integer> list = Arrays.stream(elements).boxed().collect(Collectors.toList());
            Collections.rotate(list, i + 1);
            for (int j = 1; j <= elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < j; k++) {
                    Integer gets = list.get(k);
                    sum += gets;
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
