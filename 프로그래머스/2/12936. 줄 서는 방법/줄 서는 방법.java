import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        long[] fact = new long[n + 1];
        fact[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            nums.add(i);
        }

        k--; 
        for (int i = 0; i < n; i++) {
            long f = fact[n - 1 - i];
            int idx = (int) (k / f);
            result[i] = nums.remove(idx);
            k %= f;
        }
        return result;
    }
}