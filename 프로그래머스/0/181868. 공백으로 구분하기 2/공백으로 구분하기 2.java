import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        String[] answer = new String[st.countTokens()];
        
        int idx = 0;
        while (st.hasMoreTokens()) {
            answer[idx++] = st.nextToken();
        }
        
        return answer;
    }
}
