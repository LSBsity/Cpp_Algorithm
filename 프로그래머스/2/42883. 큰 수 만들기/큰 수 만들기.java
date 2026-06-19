import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        char[] chars = number.toCharArray();
        Deque<Integer> stk = new ArrayDeque<>();
        
        stk.push(chars[0] - '0');
        int cnt = 0;
        for (int i = 1; i < chars.length; i++) {
            int val = chars[i] - '0';
            
            while (!stk.isEmpty() && stk.peek() < val && cnt < k) {
                stk.pop();
                cnt++;
            }
            
            stk.push(val);
        }       
        
        while (cnt < k) {
            stk.pop();
            cnt++;
        }
        
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        
        
        return sb.reverse().toString();
    }
}
/**

**/