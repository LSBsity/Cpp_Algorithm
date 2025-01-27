import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    boolean solution(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty() || stk.peek() != '(') {
                    return false;
                }
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}