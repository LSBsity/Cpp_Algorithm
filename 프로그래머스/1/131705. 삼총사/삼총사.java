import java.util.*;

class Solution {
    
    static int answer = 0;
    public int solution(int[] number) {
        go(number, new boolean[number.length], 0, 0, 0);
        return answer;
    }
    
    private void go(int[] number, boolean[] visited, int r, int depth, int sum) {
        if (depth == 3) {
            if (sum == 0) answer++; 
            return;
        }
        
        for (int i = r; i < number.length; i++) {
            go(number, visited, i + 1, depth + 1, sum + number[i]);
        }
    }
}