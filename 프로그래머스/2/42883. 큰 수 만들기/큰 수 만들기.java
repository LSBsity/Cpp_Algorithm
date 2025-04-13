import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            int current = number.charAt(i) - '0';
            while (!stk.isEmpty() && k > 0 && stk.peekLast() < current) {
                stk.pollLast();
                k--;
            }
            stk.addLast(current);
        }

        while (k-- > 0) {
            stk.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i: stk) {
            sb.append(i);
        }

        return sb.toString();
    }
}