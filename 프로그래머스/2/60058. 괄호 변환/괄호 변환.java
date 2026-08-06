import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
    
        return this.go(p);
    }
    
    public String go(String p) {
        if (p.isEmpty()) return "";
        
        String u = "";
        String v = "";
        for (int i = 0, j = 0, k = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') j++;
            else k++;
            
            if (j == k) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1, p.length());
                break;
            }
        }

        if (check(u)) {
            return u + go(v);
        }
        
        return "(" + go(v) + ")" + flip(u.substring(1, u.length() - 1));
    }
    private String flip(String str) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '(' ? ')' : '(');
        }
                      
        return sb.toString();
    }
    
    private boolean check(String str) {
        Deque<Character> stk = new ArrayDeque<>();
        
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                stk.pop();
            }
        }
        
        return stk.isEmpty();
    }
}