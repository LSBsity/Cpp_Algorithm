import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toString(n, 3);
        
        int p = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') { p++; continue; }
            
            answer += (c - '0') * (int) Math.pow(3, p);
            p++;
        }
        
        
        return answer;
    }
}