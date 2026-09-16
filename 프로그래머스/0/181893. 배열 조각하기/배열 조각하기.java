import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr.clone();
        
        for (int i = 0; i < query.length; i++) {
            int idx = query[i];
            if (i % 2 == 0) {
                answer = Arrays.copyOfRange(answer, 0, idx + 1);
            } else {
                answer = Arrays.copyOfRange(answer, idx, answer.length);
            }
        }
        
        return answer;
    }
}