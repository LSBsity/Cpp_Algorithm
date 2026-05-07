import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isBlank = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isBlank = true;
                continue;
            }
            
            if (isBlank) {
                if (Character.isAlphabetic(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
                isBlank = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        return sb.toString();
    }
}