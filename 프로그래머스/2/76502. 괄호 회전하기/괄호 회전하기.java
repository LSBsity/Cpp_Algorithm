import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int solution(String s) {
        List<String> list = s.chars().mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.toList());
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(String.join("", list))) {
                count++;
            }
            Collections.rotate(list, -1);
        }

        return count;
    }

    public boolean check(String str) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(c);
            } else if (c == ')') {
                if (stk.peek() != '(') {
                    return false;
                }
                stk.pop();
            } else if (c == '}') {
                if (stk.peek() != '{') {
                    return false;
                }
                stk.pop();
            } else if (c == ']') {
                if (stk.peek() != '[') {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}
