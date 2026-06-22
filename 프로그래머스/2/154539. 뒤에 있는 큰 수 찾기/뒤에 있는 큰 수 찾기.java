import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                int idx = stk.pop();
                answer[idx] = numbers[i];
            }
            stk.push(i);
        }
    
        return answer;
    }
}