import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            int current = number.charAt(i) - '0';
            while (!stk.isEmpty() && k > 0 && stk.peek() < current) {
                stk.pop();
                k--;
            }
            stk.push(current);
        }

        while (k-- > 0) {
            stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i: stk) {
            sb.append(i);
        }

        return sb.reverse().toString();
    }
}