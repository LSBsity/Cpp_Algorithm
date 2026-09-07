import java.util.*;
class Solution {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n >= 1) {
            int rem = (int)(n % 10L);
            n /= 10L;
            list.add(rem);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}