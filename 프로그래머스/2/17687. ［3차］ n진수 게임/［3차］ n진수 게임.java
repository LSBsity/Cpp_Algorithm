import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
         for (int i = 0; i <= t * m; i++) {
             sb.append(Integer.toString(i, n));
         }
        
        StringBuilder answer = new StringBuilder();
        char[] chars = sb.toString().toCharArray();

        
        if (Character.isDigit(chars[p - 1])) {
            answer.append(chars[p - 1]);
        } else {
            answer.append(Character.toUpperCase(chars[p - 1]));
        }
        
        for (int i = p; i < chars.length; i++) {
            
            if (i % m == p - 1) {
                if (Character.isDigit(chars[i])) {
                    answer.append(chars[i]);
                } else {
                    answer.append(Character.toUpperCase(chars[i]));
                }
            }
            
            if (answer.length() == t) break;
        }
        
        return answer.toString();
    }
}