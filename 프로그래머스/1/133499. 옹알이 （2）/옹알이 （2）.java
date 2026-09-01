import java.util.*;

class Solution {
    
    static final String[] BABBLING = {"ye", "woo", "ma", "aya"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            
            for (String bab : BABBLING) {
                int repeat = str.length() / bab.length();
                while (repeat >= 2) {
                    String temp = bab.repeat(repeat);
                    str = str.replaceAll(temp, "1");
                    repeat--;
                }
            }
            
            for (String bab : BABBLING) {
                str = str.replaceAll(bab, "2");
            }
            boolean check = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '2') {
                    check = false;
                    break;
                }
            }
            if (check) answer++;
        }
        
        return answer;
    }
}