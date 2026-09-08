import java.util.*;

class Solution {
    public int[] solution(int[] arr, int div) {
        List<Integer> list = new ArrayList<>();
        
        for (int i : arr) {
            if (i % div == 0) {
                list.add(i);
            }
        }
        
        if (list.isEmpty()) return new int[] {-1};
        return list.stream().mapToInt(i -> i).sorted().toArray();
    }
}