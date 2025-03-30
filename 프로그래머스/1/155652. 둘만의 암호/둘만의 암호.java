import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        
        for (char chars : skip.toCharArray()) {
            set.add(chars);
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            for (int j = 0; j < index; j++) {
                do {
                    c++;    
                    if (c > 'z') {
                      c = 'a';
                    }
                } while (set.contains(c));
   
            }
            chars[i] = c;
        }
        
        return new String(chars);
    }
}