import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Stack<Integer> stk = new Stack<>();
        for (int i : arr) {
            stk.push(i);
            int size = stk.size();
            if (size >= 4) {
                if (stk.get(size - 4) == 1 && stk.get(size - 3) == 2 && stk.get(size - 2) == 3 && stk.get(size - 1) == 1) {
                    for (int j = 0; j < 4; j++) {
                        stk.pop();
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}