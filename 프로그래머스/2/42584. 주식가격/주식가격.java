import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Deque<Integer> stk = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++) {
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]) { 
                int idx = stk.pop(); 
                answer[idx] = i - idx; 
            }
            stk.push(i);
        }
        
        while (!stk.isEmpty()) {
            int idx = stk.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}
/**

**/