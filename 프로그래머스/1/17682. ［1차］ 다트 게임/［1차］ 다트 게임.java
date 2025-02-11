import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String dartResult) {
        Deque<Integer> stk = new ArrayDeque<>();

        char[] charArray = dartResult.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (Character.isDigit(c)) {
                int ints = (int) c - '0';
                if (charArray[i + 1] == '0') {
                    stk.push(ints * 10);
                    i++;
                } else {
                    stk.push(ints);
                }
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int pow = 0;
                if (c == 'S') {
                    pow = 1;
                } else if (c == 'D') {
                    pow = 2;
                } else {
                    pow = 3;
                }
                stk.push((int) Math.pow(stk.pop(), pow));
            } else if (c == '*' || c == '#') {
                Integer popped = stk.pop();
                if (c == '#') {
                    stk.push(popped * -1);
                } else {
                    if (stk.isEmpty()) {
                        stk.push(popped * 2);
                    } else {
                        stk.push(stk.pop() * 2);
                        stk.push(popped * 2);
                    }
                }
            }
        }

        int sum = 0;
        while (!stk.isEmpty()) {
            sum += stk.pop();
        }

        return sum;
    }
}