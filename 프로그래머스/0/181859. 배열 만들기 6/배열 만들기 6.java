import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (stk.isEmpty()) {
                stk.addLast(arr[i]);
            } else if (stk.peekLast() == arr[i]) {
                stk.pollLast();
            } else {
                stk.addLast(arr[i]);
            }
        }

        if (stk.isEmpty()) return new int[]{-1};
        return stk.stream().mapToInt(i -> i).toArray();
    }
}
