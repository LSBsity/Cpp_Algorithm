import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1}; 
        
        int base = s / n;
        int rem = s % n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, base);
        
        for (int i = n - 1; i >= n - rem; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}