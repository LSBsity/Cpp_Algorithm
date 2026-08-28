import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < cards1.length; i++) {
            q1.offer(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            q2.offer(cards2[i]);
        }
        
        int idx = 0;
        while (idx < goal.length) {
            String want = goal[idx];
            
            if (!q1.isEmpty() && want.equals(q1.peek())) {
                q1.poll();
                idx++;
            } else if (!q2.isEmpty() && want.equals(q2.peek())) {
                q2.poll();
                idx++;
            } else {
                break;
            }
        }

        if (idx < goal.length) {
            return "No";
        }
        
        return "Yes";
    }
}