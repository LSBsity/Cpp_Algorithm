import java.util.*;

class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        
        int temp = -30001;
          for (int[] route : arr) {
            if (temp < route[0]) {
                temp = route[1]; 
                answer++;
            }
        }   
        
        return answer;
    }
}