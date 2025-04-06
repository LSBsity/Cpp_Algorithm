import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (var w : works) {
            q.offer(w);
        }
        
        for (int i = 0; i < n; i++) {
            int value = q.poll();
            if (value == 0) return 0;
            q.offer(value - 1);
        }
        
        while (!q.isEmpty()) {
            int value = q.poll();
            answer += value * value;
        }
        
        return answer;
    }
}