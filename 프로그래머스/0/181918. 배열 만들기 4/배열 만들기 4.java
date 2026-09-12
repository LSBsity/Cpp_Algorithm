import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        
        while (i < arr.length) {
            if (dq.isEmpty()) {
                dq.offerFirst(arr[i]);
                i++;
            } else if (dq.peekLast() < arr[i]) {
                dq.offerLast(arr[i]);
                i++;
            } else if (dq.peekLast() >= arr[i]) {
                dq.pollLast();
            }
        }
        int[] answer = new int[dq.size()];
        int idx = 0;
        while (!dq.isEmpty()) {
            answer[idx++] = dq.pollFirst();
        }
        
        return answer;
    }
}