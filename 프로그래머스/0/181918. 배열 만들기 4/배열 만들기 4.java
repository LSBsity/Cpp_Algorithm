import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public int[] solution(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        int i = 0;
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.addFirst(arr[i]);
            } else if (stk.peekLast() < arr[i]) {
                stk.addLast(arr[i]);
            } else if (stk.peekLast() >= arr[i]) {
                stk.removeLast();
                continue;
            }
            i++;
        }
        return stk.stream().mapToInt(val -> val).toArray();
    }
}