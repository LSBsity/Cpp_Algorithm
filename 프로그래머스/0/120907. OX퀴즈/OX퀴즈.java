import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int idx = 0;
        for (String str : quiz) {
            String[] split = str.split("[ =]+");
            
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[2]);
            int z = Integer.parseInt(split[3]);
            
            if (split[1].equals("-")) y *= -1;  
        
            answer[idx++] = x + y == z ? "O" : "X";
        }
        
        return answer;
    }
}