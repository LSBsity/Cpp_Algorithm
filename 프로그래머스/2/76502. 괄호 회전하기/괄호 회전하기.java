import java.util.*;

class Solution {
    
    static Map<Character, Character> map = new HashMap<>();
    
    public int solution(String s) {
        int answer = 0;
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for (int i = 0; i < s.length(); i++) {
            if (this.go(i, s)) answer++;            
        }
        
        return answer;
    }
    
    private boolean go(int start, String s) {
        Deque<Character> stk = new ArrayDeque<>();

        int idx = start;
        int cnt = s.length();
        
        while (--cnt >= 0) {
            char c = s.charAt(idx);
            
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                if (map.get(stk.peek()) != c) {
                    return false;
                }
                stk.pop();
            }
            
            idx = (idx + 1) % s.length();
        } 
        
        return stk.isEmpty();
    }
}