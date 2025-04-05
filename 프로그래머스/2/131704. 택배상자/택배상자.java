import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> mains = new ArrayDeque<>();
        for (int i = order.length; i >= 1; i--) {
            mains.push(i);
        }
        Deque<Integer> subs = new ArrayDeque<>();
        
        int idx = 0, answer = 0;
        while (!mains.isEmpty()) {
            int value = mains.pop();
            if (value != order[idx]) { 
                if (subs.isEmpty() || subs.peek() != order[idx]) {
                    subs.push(value);              
                }
            } else if (value == order[idx]) {
                answer++;          
                idx++;
            }    
            while (!subs.isEmpty() && subs.peek() == order[idx]) {
                subs.pop();
                answer++;
                idx++;    
            }
        }
        
        return answer;
    }
}