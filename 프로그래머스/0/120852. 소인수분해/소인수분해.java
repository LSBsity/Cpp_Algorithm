import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int val = 2;
        while (val <= n) {
            while (n % val == 0) {
                list.add(val);
                n /= val;
            }
            val++;
        }
        
        return list.isEmpty() ?
            new int[] {n} : list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}
