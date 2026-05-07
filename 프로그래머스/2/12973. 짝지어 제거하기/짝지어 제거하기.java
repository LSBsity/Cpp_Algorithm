import java.util.*;

class Solution{
    public int solution(String s){
        Deque<Character> stk = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(c);
            } else if (stk.peek() == c) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
}