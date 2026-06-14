import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            
            for (int t : times) {
                people += mid / t;
            }
            
            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
     
        return answer;
    }
}