import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int solution(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stk.isEmpty() || stk.peek() != s.charAt(i)) {
                stk.push(s.charAt(i));
            } else {
                stk.pop();
            }

        }

        return stk.isEmpty() ? 1 : 0;
    }
}