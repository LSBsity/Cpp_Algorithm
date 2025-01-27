import java.util.*;

class Solution {

    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int last = -1;
        for (int i : arr) {
            if (last != i) {
                list.add(i);
            }
            last = i;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
